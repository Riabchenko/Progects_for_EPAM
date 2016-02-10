package com.intellect25.company.entity.interfaceObject;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by apple on 1/12/16.
 */
public interface Employee {
    /**
     * Gets the value of the firstName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    String getFirstName();

    /**
     * Sets the value of the firstName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    void setFirstName(String value);

    /**
     * Gets the value of the middleName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    String getMiddleName();

    /**
     * Sets the value of the middleName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    void setMiddleName(String value);

    /**
     * Gets the value of the lastName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    String getLastName();

    /**
     * Sets the value of the lastName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    void setLastName(String value);

    /**
     * Gets the value of the birthday property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    XMLGregorianCalendar getBirthday();

    /**
     * Sets the value of the birthday property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    void setBirthday(XMLGregorianCalendar value);

    /**
     * Gets the value of the dateOfGetJob property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    XMLGregorianCalendar getDateOfGetJob();

    /**
     * Sets the value of the dateOfGetJob property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    void setDateOfGetJob(XMLGregorianCalendar value);

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    Integer getId();

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    void setId(Integer value);
}
