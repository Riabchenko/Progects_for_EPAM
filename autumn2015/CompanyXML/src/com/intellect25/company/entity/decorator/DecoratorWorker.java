package com.intellect25.company.entity.decorator;

import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.interfaceObject.Worker;

/**
 * Created by apple on 1/12/16.
 */
public class DecoratorWorker extends Decorator implements Worker {
    protected Employee employee;

    public DecoratorWorker(Employee employee) {
        super(employee);
    }
}
