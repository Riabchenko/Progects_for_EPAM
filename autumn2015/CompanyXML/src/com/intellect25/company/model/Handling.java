package com.intellect25.company.model;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.entity.object.TypeEmployee;
import com.intellect25.company.entity.interfaceObject.Company;
import com.intellect25.company.entity.interfaceObject.Employee;

import java.util.List;

/**
 * Created by apple on 1/17/16.
 */
public interface Handling {
    NewRequest sortBy(Company company, TypeSort type);

    NewRequest setNewEmployee(Company company, Employee employee);

    NewRequest deleteEmployee(Company company, Integer idEmployee);

    NewRequest changeTypeOfEmployee(Company company, Integer idEmployee, TypeEmployee newTypeEmployee,
                                    List<Integer> listWorkers,int idManager,String info);

    NewRequest bindWorkerToManager(Company company, int worker, int manager);

}
