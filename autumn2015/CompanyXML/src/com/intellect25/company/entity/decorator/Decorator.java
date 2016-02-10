package com.intellect25.company.entity.decorator;

import com.intellect25.company.entity.interfaceObject.Employee;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by apple on 1/18/16.
 */
public abstract class Decorator implements Employee{
    protected Employee employee;

    public Decorator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getFirstName() {
        return employee.getFirstName();
    }

    @Override
    public void setFirstName(String value) {
        employee.setFirstName(value);
    }

    @Override
    public String getMiddleName() {
        return employee.getMiddleName();
    }

    @Override
    public void setMiddleName(String value) {

    }

    @Override
    public String getLastName() {
        return employee.getLastName();
    }

    @Override
    public void setLastName(String value) {
        employee.setLastName(value);
    }

    @Override
    public XMLGregorianCalendar getBirthday() {
        return employee.getBirthday();
    }

    @Override
    public void setBirthday(XMLGregorianCalendar value) {
        employee.setBirthday(value);
    }

    @Override
    public XMLGregorianCalendar getDateOfGetJob() {
        return employee.getDateOfGetJob();
    }

    @Override
    public void setDateOfGetJob(XMLGregorianCalendar value) {
        employee.setDateOfGetJob(value);
    }

    @Override
    public Integer getId() {
        return employee.getId();
    }

    @Override
    public void setId(Integer value) {
        employee.setId(value);
    }
}
