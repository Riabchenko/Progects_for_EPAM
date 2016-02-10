
package com.intellect25.company.entity.object;

import com.intellect25.company.entity.interfaceObject.ListWorkers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for managerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="managerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://com.intellect25.company.resources4/mns}employee">
 *       &lt;sequence>
 *         &lt;element name="listWorkers" type="{http://com.intellect25.company.resources4/mns}listWorkers" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "managerType", namespace = "http://com.intellect25.company.resources4/mns", propOrder = {
    "listWorkers"
})
public class ManagerType
    extends EmployeeImpl implements com.intellect25.company.entity.interfaceObject.Manager {

    @XmlElement(namespace = "http://com.intellect25.company.resources4/mns")
    protected ListWorkers listWorkers;

    /**
     * Gets the value of the listWorkers property.
     * 
     * @return
     *     possible object is
     *     {@link ListWorkersImpl }
     *     
     */
    @Override
    public ListWorkers getListWorkers() {
        return listWorkers;
    }

    /**
     * Sets the value of the listWorkers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListWorkersImpl }
     *     
     */
    @Override
    public void setListWorkers(com.intellect25.company.entity.interfaceObject.ListWorkers value) {
        this.listWorkers = value;
    }

}
