package com.intellect25.company.model;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.entity.interfaceObject.Company;
import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.object.TypeEmployee;

import java.util.List;

/**
 * Created by apple on 1/17/16.
 */
public class FacadeImpl implements Facade {
    private  static Facade facade;
    private Parser parser;
    private Handling handling;

    private FacadeImpl() {
        this.parser = new DomParser();
        this.handling = new HandlingImpl();
    }

    public static Facade getInstance(){
        if (facade == null){
            facade = new FacadeImpl();
        }
        return facade;
    }

    @Override
    public NewRequest parse(String path){
        return parser.parse(path);
    }
    @Override
    public NewRequest createXML(String filePath, Company company){
        return parser.createXML(filePath, company);
    }
    @Override
    public NewRequest sortBy(Company company, TypeSort type){
        return handling.sortBy(company, type);
    }

    @Override
    public NewRequest setNewEmployee(Company company, Employee employee){
        return handling.setNewEmployee(company,employee);
    }
    @Override
    public NewRequest deleteEmployee(Company company, Integer idEmployee){
        return handling.deleteEmployee(company,idEmployee);
    }
    @Override
    public NewRequest changeTypeOfEmployee(Company company, Integer idEmployee, TypeEmployee newTypeEmployee,
                                           List<Integer> listWorkers,int idManager,String info){
        return handling.changeTypeOfEmployee(company,idEmployee,newTypeEmployee,listWorkers, idManager, info);
    }

    @Override
    public NewRequest bindWorkerToManager(Company company, int worker, int manager) {
        return handling.bindWorkerToManager(company,worker,manager);
    }


}
