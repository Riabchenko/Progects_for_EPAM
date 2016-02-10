package com.intellect25.company.entity.interfaceObject;

import com.intellect25.company.entity.object.ManagerType;
import com.intellect25.company.entity.object.OtherType;
import com.intellect25.company.entity.object.WorkerType;

import java.util.List;
import java.util.Map;

/**
 * Created by apple on 1/12/16.
 */
public interface Company {
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
    List<Employee> getOtherOrManagerOrWorker();

    /**
     * Store id and link to object of employee
     *
     * @return map of employee
     */
    Map<Integer,Employee> getMapOtherOrManagerOrWorker();

    /**
     * Store id of workers and link to object of manager
     *
     * @return map of employee
     */
    Map<Integer,Integer> getWorkersOfManagerMap();
}
