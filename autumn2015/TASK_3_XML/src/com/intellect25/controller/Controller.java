package com.intellect25.controller;

import com.intellect25.entity.Pavilion;
import com.intellect25.model.*;
import com.intellect25.view.Writer;

import java.io.File;
import java.util.Collections;

/**
 * Controller
 *
 * @author Riabchenko Aliona
 */
public class Controller {

    /** Path of xml and xsd */
    private static final String XML_FILE_PATH = "src/com/intellect25/resources/stone.xml";
    private static final String XSD_FILE_PATH = "src/com/intellect25/resources/stone.xsd";
    private static final String StAX_XML_FILE_PATH = "src/com/intellect25/resources/result/XMLViaStAX.xml";
    private static final String DOM_XML_FILE_PATH = "src/com/intellect25/resources/result/XMLViaDOM.xml";
    private static final String DOM_SORT_BY_ID_XML_FILE_PATH = "src/com/intellect25/resources/result/XMLViaDOMSortById.xml";
    private static final String SAX_SORT_BY_NAME_XML_FILE_PATH = "src/com/intellect25/resources/result/XMLViaSAXSortByName.xml";
    private static final String StAX_SORT_BY_PRECIOUSNESS_NAME_XML_FILE_PATH = "src/com/intellect25/resources/result/XMLViaStAXSortByPreciousness.xml";
    private static final String SAX_XML_FILE_PATH = "src/com/intellect25/resources/result/XMLViaSAX.xml";

    /** Names of value for display them */
    private static final String StAX = "StAX - ";
    private static final String XML = "XML - ";
    private static final String SAX = "SAX - ";
    private static final String DOM = "DOM - ";
    private static final String DOM_SORT_BY_ID = "DOM_SORT_BY_ID - ";
    private static final String SAX_SORT_BY_NAME = "SAX_SORT_BY_NAME - ";
    private static final String StAX_SORT_BY_PRECIOUSNESS = "StAX_SORT_BY_PRECIOUSNESS - ";

    /**
     * Start all parsers and validations
     */
    public void start(){

        /* Create object of File from xml*/
        File pavilionXmlFile = new File(XML_FILE_PATH);

        /* Create string from xml*/
        String xmlAsString = FileReader.readFile(XML_FILE_PATH);

        /* Create SAX parser and parse xml. As result, it creates object Pavilion */
        SaxParser saxParser = new SaxParser();
        Pavilion pavilionViaSAX = saxParser.parse(XML_FILE_PATH);

        /* Create DOM parser and parse xml. As result, it creates object Pavilion */
        DomParser domParser = new DomParser();
        Pavilion pavilionDOM = domParser.parse(pavilionXmlFile);

         /* Create StAX parser and parse xml. As result, it creates object Pavilion */
        StAXParser stAXParser = new StAXParser();
        Pavilion pavilionViaStAX = stAXParser.parse(xmlAsString);

        /* StX parser creates xml from object which was creating by DOM,StAX and SAX */
        stAXParser.createXML(DOM_XML_FILE_PATH, pavilionDOM);
        stAXParser.createXML(StAX_XML_FILE_PATH, pavilionViaStAX);
        stAXParser.createXML(SAX_XML_FILE_PATH, pavilionViaSAX);

        /* Sorts DOM with using comparator BY_ID */
        Collections.sort(pavilionDOM.getGem().getStone(), ComparatorsForSort.BY_ID.getComparator());
        stAXParser.createXML(DOM_SORT_BY_ID_XML_FILE_PATH, pavilionDOM);

        /* Sorts SAX with using comparator BY_NAME */
        Collections.sort(pavilionDOM.getGem().getStone(), ComparatorsForSort.BY_NAME.getComparator());
        stAXParser.createXML(SAX_SORT_BY_NAME_XML_FILE_PATH, pavilionViaSAX);

        /* Sorts StAX with using comparator BY_PRECIOUSNESS */
        Collections.sort(pavilionDOM.getGem().getStone(), ComparatorsForSort.BY_PRECIOUSNESS.getComparator());
        stAXParser.createXML(StAX_SORT_BY_PRECIOUSNESS_NAME_XML_FILE_PATH, pavilionDOM);

        /* Validation generated xml */
        Writer.display(String.valueOf(XML+new XMLValidationViaXSD().validate(XML_FILE_PATH, XSD_FILE_PATH)));
        Writer.display(String.valueOf(DOM+new XMLValidationViaXSD().validate(DOM_XML_FILE_PATH, XSD_FILE_PATH)));
        Writer.display(String.valueOf(StAX+new XMLValidationViaXSD().validate(StAX_XML_FILE_PATH, XSD_FILE_PATH)));
        Writer.display(String.valueOf(SAX+new XMLValidationViaXSD().validate(SAX_XML_FILE_PATH, XSD_FILE_PATH)));
        Writer.display(String.valueOf(DOM_SORT_BY_ID+new XMLValidationViaXSD().validate(DOM_SORT_BY_ID_XML_FILE_PATH, XSD_FILE_PATH)));
        Writer.display(String.valueOf(SAX_SORT_BY_NAME+new XMLValidationViaXSD().validate(SAX_SORT_BY_NAME_XML_FILE_PATH, XSD_FILE_PATH)));
        Writer.display(String.valueOf(StAX_SORT_BY_PRECIOUSNESS+new XMLValidationViaXSD().validate(StAX_SORT_BY_PRECIOUSNESS_NAME_XML_FILE_PATH, XSD_FILE_PATH)));
    }
}
