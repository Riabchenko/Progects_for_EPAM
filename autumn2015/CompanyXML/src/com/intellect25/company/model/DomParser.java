package com.intellect25.company.model;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.NewRequestImpl;
import com.intellect25.company.entity.object.ObjectFactory;
import com.intellect25.company.entity.object.TypeEmployee;
import com.intellect25.company.entity.interfaceObject.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * SimpleDomParser to parse xml documents
 *
 * @author Riabchenko Aliona
 */
public class DomParser extends Parser {
    private ObjectFactory factory = ObjectFactory.getInstance();

    /**
     * Parse xml document
     *
     * @param file input xml document
     * @return object of Pavilion
     */
    public NewRequest parse(String file) {
        Element node = null;
        NewRequest newRequest = factory.createResult();

        try {

            /* Create document and element root from file */
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element root = document.getDocumentElement();

            /* Create main node */
            node = (Element) root.getChildNodes();
            newRequest.setCompany(searchAndCreate(node));
        } catch (SAXException | ParserConfigurationException | IOException e) {
            newRequest.setError("Not found file");
        }
        return newRequest;
    }

    public NewRequest createXML(String filePath, Company company) {
        NewRequest request = new NewRequestImpl();
        XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(filePath));
            xmlw.writeStartDocument();
            xmlw.writeCharacters("\n");
            xmlw.writeStartElement(MNS, PAVILION, START_ELEMENT_HTTP_MNS);
            xmlw.writeNamespace(MNS, START_ELEMENT_HTTP_MNS);
            xmlw.writeNamespace(XS, START_ELEMENT_HTTP_SCHEMA);
            xmlw.writeAttribute(XS_LOCATION, START_ELEMENT_HTTP_MNS + NAME_XSD);
            xmlw.writeCharacters("\n");

            for (Employee employee : company.getMapOtherOrManagerOrWorker().values()) {
                if (employee instanceof Manager)
                    xmlw.writeStartElement(MNS_+MANAGER);
                else  if (employee instanceof Other)
                    xmlw.writeStartElement(MNS_+OTHER);
                else if (employee instanceof Worker)
                    xmlw.writeStartElement(MNS_+WORKER);

                xmlw.writeAttribute(ID, String.valueOf(employee.getId()));
                xmlw.writeStartElement(MNS_ + FIRST_NAME);
                xmlw.writeCharacters(employee.getFirstName());
                xmlw.writeEndElement();
                xmlw.writeStartElement(MNS_ + MIDDLE_NAME);
                xmlw.writeCharacters(employee.getMiddleName());
                xmlw.writeEndElement();
                xmlw.writeStartElement(MNS_ + LAST_NAME);
                xmlw.writeCharacters(employee.getLastName());
                xmlw.writeEndElement();

                xmlw.writeStartElement(MNS_ + BIRTHDAY);
                xmlw.writeCharacters(String.valueOf(employee.getBirthday()));
                xmlw.writeEndElement();

                xmlw.writeStartElement(MNS_ + DAY_JOB);
                xmlw.writeCharacters(String.valueOf(employee.getDateOfGetJob()));
                xmlw.writeEndElement();

                if (employee instanceof Manager) {
                    xmlw.writeStartElement(MNS_ + LIST_WORKER);
                    if (((Manager) employee).getListWorkers() != null) {
                        for (Integer idWorker : ((Manager) employee).getListWorkers().getWorkerId()) {
                            xmlw.writeStartElement(MNS_ + WORKER_ID);
                            xmlw.writeCharacters(String.valueOf(idWorker));
                            xmlw.writeEndElement();
                        }
                    }
                    xmlw.writeEndElement();
                }else if (employee instanceof Other){
                    xmlw.writeStartElement(MNS_+INFO);
                    xmlw.writeCharacters(((Other) employee).getInfo());
                    xmlw.writeEndElement();
                }
                xmlw.writeEndElement();
                xmlw.writeCharacters("\n");
            }
            xmlw.writeEndElement();
            xmlw.writeEndDocument();
            xmlw.close();
            request.setMessage(XML_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            request.setError(NOT_PATH);
        }
        return request;
    }

    /**
     * Search and create EmployeeImpl
     *
     * @param employee main node
     * @return object of company
     */
    private Company searchAndCreate(Element employee) {
        Company company = factory.createCompanyType();
        if (employee != null) {

            /* Search all managers*/
            NodeList listManager = searchElementByTag(employee,MNS_+MANAGER);
            int sizeListOfManager = listManager.getLength();
            for (int i = 0; i < sizeListOfManager; i++) { //for each manager search workers
                com.intellect25.company.entity.interfaceObject.Employee manager = createEmployee(listManager.item(i), TypeEmployee.MANAGER);

                ListWorkers listWorkers = factory.createListWorkers();
                NodeList list = searchElementByTag((Element) listManager.item(i), MNS_+WORKER_ID);
                int sizeList = list.getLength();
                Map<Integer,Integer> mapWorkersId = new HashMap<>();
                for (int x = 0; x < sizeList; x++){
                    int idOfWorker = Integer.valueOf(list.item(x).getChildNodes().item(0).getNodeValue());
                    listWorkers.getWorkerId().add(idOfWorker);
                    mapWorkersId.put(idOfWorker,manager.getId());
                }
                ((Manager)manager).setListWorkers(listWorkers);
                company.getWorkersOfManagerMap().putAll(mapWorkersId);
                company.getMapOtherOrManagerOrWorker().put(manager.getId(),manager);
            }

            /* Search all other*/
            NodeList listOther= searchElementByTag(employee, MNS_+OTHER);
            int sizeListOther = listOther.getLength();
            for (int i = 0; i < sizeListOther; i++) { //для каждого менеджера ищем worker
                Other other = (Other) createEmployee(listOther.item(i),TypeEmployee.OTHER);
                other.setInfo(getNameValue((Element) listOther.item(i), MNS_+INFO));
                company.getMapOtherOrManagerOrWorker().put(other.getId(),other);
            }

            /* Search all worker*/
            NodeList listWorker= searchElementByTag(employee, MNS_+WORKER);
            int sizeListWorker = listWorker.getLength();
            for (int i = 0; i < sizeListWorker; i++) { //для каждого менеджера ищем worker
                com.intellect25.company.entity.interfaceObject.Employee worker = createEmployee(listWorker.item(i),TypeEmployee.WORKER);
                company.getMapOtherOrManagerOrWorker().put(worker.getId(),worker);
            }
        }
        return company;
    }

    /**
     * Create object of employee from node
     *
     * @param employee employee
     * @param type type of employee
     * @return employee
     */
    private Employee createEmployee(Node employee,TypeEmployee type){
        Employee employeeObject = factory.createEmployee(type);
        employeeObject.setId(Integer.valueOf(getAttributeOfNode(employee, ID))); //id woker
        employeeObject.setFirstName(getNameValue((Element) employee, MNS_+FIRST_NAME));
        employeeObject.setMiddleName(getNameValue((Element) employee, MNS_+MIDDLE_NAME));
        employeeObject.setLastName(getNameValue((Element) employee,MNS_+LAST_NAME));
//ADD CHECK NULL
        try {
            employeeObject.setBirthday(DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(getNameValue((Element) employee, MNS_+BIRTHDAY)));
            employeeObject.setDateOfGetJob(DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(getNameValue((Element) employee, MNS_+DAY_JOB)));

        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return employeeObject;
    }


    /**
     * Helper - search attribute of a node
     *
     * @param node input a node
     * @param attribute attribute for searching
     * @return value of attribute
     */
    private String getAttributeOfNode(Node node, String attribute) {
        return node.getAttributes().getNamedItem(attribute).getNodeValue();
    }

    /**
     * Helper for get child value
     *
     * @param parent    parent of child
     * @param childName name of child
     * @return value
     */
    private String getNameValue(Element parent, String childName) {
        Element baby = getName(parent, childName);
        Node node = baby.getFirstChild();
        return node.getNodeValue();
    }

    /**
     * Search element by TAG
     *
     * @param element input element
     * @param tag tag for searching
     * @return NodeList
     */
    private NodeList searchElementByTag(Element element, String tag) {
        return element.getElementsByTagName(tag);
    }

    /**
     * Helper for get Child from parent
     *
     * @param parent    element of parent
     * @param childName name of child
     * @return element of child
     */
    private Element getName(Element parent, String childName) {
        NodeList nodeList = parent.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }



}
