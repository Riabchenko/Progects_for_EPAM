package com.intellect25.company.controller.command.commands;

import com.intellect25.company.controller.command.Command;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.Session;
import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.interfaceObject.ListWorkers;
import com.intellect25.company.entity.interfaceObject.Manager;
import com.intellect25.company.entity.interfaceObject.Other;
import com.intellect25.company.entity.object.ObjectFactory;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 * Created by apple on 1/18/16.
 */
public class SetNewEmployee extends Command {

    @Override
    public NewRequest execute(Session session, NewRequest request) {
        Employee employee = createEmployee(session,request);
        NewRequest newRequest = facade.setNewEmployee(session.getObject(), employee);
        session.setObject(newRequest.getCompany());
        return newRequest;
    }

    private Employee createEmployee(Session session,NewRequest request){
        ObjectFactory factory = ObjectFactory.getInstance();

        Employee employee = factory.createEmployee(request.getType());
        employee.setId(request.getId());
        employee.setFirstName(request.getFirstName());
        employee.setMiddleName(request.getMiddleName());
        employee.setLastName(request.getLastName());
        try {
            employee.setBirthday(DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(request.getBirthday()));
            employee.setDateOfGetJob(DatatypeFactory
                    .newInstance()
                    .newXMLGregorianCalendar(request.getDateOfGetJob()));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        switch (request.getType()){
            case MANAGER:
                if (request.getList() != null) {
                    ListWorkers listWorkers = factory.createListWorkers();
                    listWorkers.getWorkerId().addAll(request.getList());
                    ((Manager) employee).setListWorkers(listWorkers);
                    for (int idWorker:listWorkers.getWorkerId())
                        (session.getObject()).getWorkersOfManagerMap().put(idWorker,employee.getId());
                }
                break;
            case WORKER:
                NewRequest newRequest = facade.bindWorkerToManager(session.getObject(), employee.getId(), request.getIdManager());
                session.setObject(newRequest.getCompany());
                break;
            case OTHER:
                ((Other)employee).setInfo(request.getInfo());
                break;

        }
        return employee;
    }
}
