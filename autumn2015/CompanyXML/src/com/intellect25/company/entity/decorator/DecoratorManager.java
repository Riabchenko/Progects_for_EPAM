package com.intellect25.company.entity.decorator;


import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.interfaceObject.ListWorkers;
import com.intellect25.company.entity.interfaceObject.Manager;

/**
 * Created by apple on 1/12/16.
 */
public  class DecoratorManager extends Decorator implements Manager  {

    private ListWorkers listWorkers;

    public DecoratorManager(Employee employee) {
        super(employee);
    }

    @Override
    public ListWorkers getListWorkers() {
        return listWorkers;
    }

    @Override
    public void setListWorkers(ListWorkers value) {
        listWorkers = value;
    }

}
