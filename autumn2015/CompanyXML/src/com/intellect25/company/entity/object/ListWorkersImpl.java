
package com.intellect25.company.entity.object;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for listWorkers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listWorkers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workerId" type="{http://com.intellect25.company.resources4/mns}id" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listWorkers", namespace = "http://com.intellect25.company.resources4/mns", propOrder = {
    "workerId"
})
public class ListWorkersImpl implements com.intellect25.company.entity.interfaceObject.ListWorkers {

    @XmlElement(namespace = "http://com.intellect25.company.resources4/mns", type = Integer.class)
    protected List<Integer> workerId;

    /**
     * Gets the value of the workerId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workerId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkerId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    @Override
    public List<Integer> getWorkerId() {
        if (workerId == null) {
            workerId = new ArrayList<Integer>(); //can be hash
        }
        return this.workerId;
    }

}
