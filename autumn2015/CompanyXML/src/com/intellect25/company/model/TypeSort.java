package com.intellect25.company.model;


import com.intellect25.company.entity.interfaceObject.Employee;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by apple on 1/11/16.
 */
public enum TypeSort {
    BY_ID (new Comparator<Map.Entry<Integer, Employee>>() {
        @Override
        public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
            return (o1.getValue().getId()).compareTo(o2.getValue().getId());
        }
    }),
    BY_LAST_NAME (new Comparator<Map.Entry<Integer, Employee>>() {
        @Override
        public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
            return (o1.getValue().getLastName()).compareTo(o2.getValue().getLastName());
        }
    }),
    BY_DATE_GET_JOB (new Comparator<Map.Entry<Integer, Employee>>() {
        @Override
        public int compare(Map.Entry<Integer, Employee> o1, Map.Entry<Integer, Employee> o2) {
            return (o1.getValue().getDateOfGetJob()).compare(o2.getValue().getDateOfGetJob());
        }
    });


    private Comparator<Map.Entry<Integer, Employee>> comparator;

    TypeSort(Comparator<Map.Entry<Integer, Employee>> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Map.Entry<Integer, Employee>> getComparator(){
        return comparator;
    }
}
