//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.13 at 02:38:07 PM EET 
//


package com.intellect25.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * &lt;complexType name="stone"
 *   &lt;complexContent
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"
 *       &lt;sequence
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"
 *         &lt;element name="preciousness" type="{http://www.example.com/mns}preciousness"
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"
 *         &lt;element name="visual" type="{http://www.example.com/mns}visual"
 *         &lt;element name="value" type="{http://www.example.com/mns}value"
 *       &lt;/sequence
 *       &lt;attribute name="id"
 *         &lt;simpleType
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"
 *             &lt;pattern value="[0-9]{1,4}"
 *           &lt;/restriction
 *         &lt;/simpleType
 *       &lt;/attribute
 *     &lt;/restriction
 *   &lt;/complexContent
 * &lt;/complexType
 * 
 * @author Riabchenko Aliona
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stone", propOrder = {
    "name",
    "preciousness",
    "origin",
    "visual",
    "value"
})
public class Stone {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Preciousness preciousness;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(required = true)
    protected Visual visual;
    protected float value;
    @XmlAttribute(name = "id")
    protected Integer id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the preciousness property.
     * 
     * @return
     *     possible object is
     *     {@link Preciousness }
     *     
     */
    public Preciousness getPreciousness() {
        return preciousness;
    }

    /**
     * Sets the value of the preciousness property.
     * 
     * @param value
     *     allowed object is
     *     {@link Preciousness }
     *     
     */
    public void setPreciousness(Preciousness value) {
        this.preciousness = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the visual property.
     * 
     * @return
     *     possible object is
     *     {@link Visual }
     *     
     */
    public Visual getVisual() {
        return visual;
    }

    /**
     * Sets the value of the visual property.
     * 
     * @param value
     *     allowed object is
     *     {@link Visual }
     *     
     */
    public void setVisual(Visual value) {
        this.visual = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return value
     */
    public float getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value value
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

}