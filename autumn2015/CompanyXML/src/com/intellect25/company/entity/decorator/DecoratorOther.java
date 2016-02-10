package com.intellect25.company.entity.decorator;

import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.interfaceObject.Other;

/**
 * Created by apple on 1/12/16.
 */
public class DecoratorOther extends Decorator implements Other {
    private String info;

    public DecoratorOther(Employee employee) {
        super(employee);
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String value) {
        info = value;
    }
}
