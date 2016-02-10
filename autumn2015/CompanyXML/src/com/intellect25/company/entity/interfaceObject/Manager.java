package com.intellect25.company.entity.interfaceObject;

import com.intellect25.company.entity.object.ListWorkersImpl;

/**
 * Created by apple on 1/12/16.
 */
public interface Manager extends Employee {
    /**
     * Gets the value of the listWorkers property.
     *
     * @return
     *     possible object is
     *     {@link ListWorkersImpl }
     *
     */
    ListWorkers getListWorkers();

    /**
     * Sets the value of the listWorkers property.
     *
     * @param value
     *     allowed object is
     *     {@link ListWorkersImpl }
     *
     */
    void setListWorkers(ListWorkers value);
}
