
package com.intellect25.company.entity.object;

import com.intellect25.company.entity.interfaceObject.Company;
import com.intellect25.company.entity.interfaceObject.Employee;

import javax.xml.bind.annotation.*;
import java.util.*;


/**
 * <p>Java class for companyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="companyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="other" type="{http://com.intellect25.company.resources4/mns}otherType"/>
 *         &lt;element name="manager" type="{http://com.intellect25.company.resources4/mns}managerType"/>
 *         &lt;element name="worker" type="{http://com.intellect25.company.resources4/mns}workerType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "companyType", namespace = "http://com.intellect25.company.resources4/mns", propOrder = {
    "otherOrManagerOrWorker"
})
public class CompanyType implements Company {

    @XmlElements({
        @XmlElement(name = "other", namespace = "http://com.intellect25.company.resources4/mns", type = OtherType.class),
        @XmlElement(name = "manager", namespace = "http://com.intellect25.company.resources4/mns", type = ManagerType.class),
        @XmlElement(name = "worker", namespace = "http://com.intellect25.company.resources4/mns", type = WorkerType.class)
    })
    protected List<Employee> otherOrManagerOrWorker;
    protected Map<Integer,Employee> otherOrManagerOrWorkerMap;
    protected Map<Integer,Integer> workersOfManagerMap;

    /**
     * Gets the value of the otherOrManagerOrWorker property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherOrManagerOrWorker property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherOrManagerOrWorker().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherType }
     * {@link ManagerType }
     * {@link WorkerType }
     * 
     * 
     */
    @Override
    public List<Employee> getOtherOrManagerOrWorker() {
        if (otherOrManagerOrWorker == null) {
            otherOrManagerOrWorker = new ArrayList<Employee>();
        }
        return this.otherOrManagerOrWorker;
    }

    /**
     * Store id and link to object of employee
     *
     * @return map of employee
     */
    @Override
    public Map<Integer,Employee> getMapOtherOrManagerOrWorker() {
        if (otherOrManagerOrWorkerMap == null) {
            otherOrManagerOrWorkerMap = new LinkedHashMap<Integer,Employee>();
        }
        return this.otherOrManagerOrWorkerMap;
    }

    @Override
    public Map<Integer,Integer> getWorkersOfManagerMap() {
        if (workersOfManagerMap == null) {
            workersOfManagerMap = new LinkedHashMap<Integer,Integer>();
        }
        return this.workersOfManagerMap;
    }

}
