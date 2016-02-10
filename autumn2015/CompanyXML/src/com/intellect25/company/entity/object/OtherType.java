
package com.intellect25.company.entity.object;

import com.intellect25.company.entity.interfaceObject.Other;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for otherType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="otherType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://com.intellect25.company.resources4/mns}employee">
 *       &lt;sequence>
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "otherType", namespace = "http://com.intellect25.company.resources4/mns", propOrder = {
    "info"
})
public class OtherType
    extends EmployeeImpl implements Other {

    @XmlElement(namespace = "http://com.intellect25.company.resources4/mns", required = true)
    protected String info;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Override
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Override
    public void setInfo(String value) {
        this.info = value;
    }

}
