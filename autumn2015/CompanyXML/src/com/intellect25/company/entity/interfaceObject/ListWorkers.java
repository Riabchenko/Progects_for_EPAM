package com.intellect25.company.entity.interfaceObject;

import java.util.List;

/**
 * Created by apple on 1/12/16.
 */
public interface ListWorkers {
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
    List<Integer> getWorkerId();
}
