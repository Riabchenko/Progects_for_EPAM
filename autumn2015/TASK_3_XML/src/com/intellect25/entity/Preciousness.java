//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.13 at 02:38:07 PM EET 
//


package com.intellect25.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preciousness.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * &lt;simpleType name="preciousness"
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"
 *     &lt;enumeration value="PRECIOUS"
 *     &lt;enumeration value="SEMIPRECIOUS"
 *   &lt;/restriction
 * &lt;/simpleType
 *
 * @author Riabchenko Aliona
 *
 */
@XmlType(name = "preciousness")
@XmlEnum
public enum Preciousness {

    PRECIOUS,
    SEMIPRECIOUS;

    public String value() {
        return name();
    }

    public static Preciousness fromValue(String v) {
        return valueOf(v);
    }

}