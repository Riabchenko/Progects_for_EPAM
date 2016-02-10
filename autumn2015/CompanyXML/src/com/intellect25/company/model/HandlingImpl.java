package com.intellect25.company.model;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.entity.object.ObjectFactory;
import com.intellect25.company.entity.object.TypeEmployee;
import com.intellect25.company.entity.decorator.DecoratorFactory;
import com.intellect25.company.entity.decorator.DecoratorOther;
import com.intellect25.company.entity.interfaceObject.*;

import java.util.*;

/**
 * Created by apple on 1/17/16.
 */
public class HandlingImpl implements Handling {
    private ObjectFactory factory = ObjectFactory.getInstance();
    //================= Edit =================//

    @Override
    public NewRequest sortBy(Company company, TypeSort type){
        List<Map.Entry<Integer, Employee>> list =
                new LinkedList<>( company.getMapOtherOrManagerOrWorker().entrySet() );
        Collections.sort(list, type.getComparator());

        Map<Integer, Employee> resultMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Employee> entry : list)
        {
            resultMap.put( entry.getKey(), entry.getValue() );
        }
        company.getMapOtherOrManagerOrWorker().clear();
        company.getMapOtherOrManagerOrWorker().putAll(resultMap);
        NewRequest newRequest = factory.createResult();
        newRequest.setCompany(company);
        return newRequest;
    }

    @Override
    public NewRequest setNewEmployee(Company company, Employee employee){
        company.getMapOtherOrManagerOrWorker().put(employee.getId(), employee);
        NewRequest newRequest = factory.createResult();
        newRequest.setCompany(company);
        newRequest.setMessage("Employee was added successful");
        return newRequest;
    }

    @Override
    public NewRequest deleteEmployee(Company company, Integer idEmployee){
        List<Integer> listWorkersId = null;
        NewRequest newRequest = factory.createResult();

        if (company.getMapOtherOrManagerOrWorker().containsKey(idEmployee)) {

            Employee employee = company.getMapOtherOrManagerOrWorker().remove(idEmployee);

            if (company.getWorkersOfManagerMap().containsValue(employee.getId())){
                listWorkersId = unbindManagerFromWorkers(company,employee);
                newRequest.setList(listWorkersId);
                newRequest.setMessage("Employee was left without manager");
            } else if (company.getWorkersOfManagerMap().containsKey(employee.getId())){
                unbindWorkerFromManager(company, employee.getId());
                newRequest.setMessage("Operation is successful");
            }
            newRequest.setEmployee(employee);
            ///////// если это менеджер, то его worker куда-то деть нужно....если worker то убрать с менеджера
        }else{
            newRequest.setMessage("This employee doesn't search");
        }
        newRequest.setCompany(company);
        return newRequest;
    }

    private Company unbindWorkerFromManager(Company company,int employee){
        int idManager = company.getWorkersOfManagerMap().get(employee);
        if (idManager != 0) {
            Employee manager = company.getMapOtherOrManagerOrWorker().get(idManager);
            List<Integer> list = ((Manager) manager).getListWorkers().getWorkerId();
            for (int i = 0 ; i < list.size(); i++){
                if (list.get(i) == employee) list.remove(i);
            }
            company.getWorkersOfManagerMap().remove(employee);
        }
        return company;
    }

    private List<Integer> unbindManagerFromWorkers(Company company, Employee employee){
        List<Integer> listWorkersId = ((Manager) employee).getListWorkers().getWorkerId();
        List<Integer> listWorkers = new LinkedList<>();
        listWorkers.addAll(listWorkersId);
        for (int idWorker:listWorkersId)
            company.getWorkersOfManagerMap().remove(idWorker);//куда деть рабочих????????????????????
        ((Manager) employee).getListWorkers().getWorkerId().clear();
        return listWorkers;
    }

    @Override
    public NewRequest changeTypeOfEmployee(Company company, Integer idEmployee, TypeEmployee newTypeEmployee,
                                           List<Integer> listWorkers,int idManager,String info){
        Employee employee = null;
        NewRequest newRequest = factory.createResult();
        if (company.getMapOtherOrManagerOrWorker().containsKey(idEmployee)) {
            Employee oldEmployee = company.getMapOtherOrManagerOrWorker().get(idEmployee);
            TypeEmployee typeOldEmployee = definiteType(oldEmployee);

            if (newTypeEmployee != typeOldEmployee) {
//                newRequestImpl.setType(newTypeEmployee);
                switch (typeOldEmployee) {
                    case MANAGER:
                        unbindManagerFromWorkers(company, oldEmployee);
                        break;
                    case WORKER:
                        unbindWorkerFromManager(company, oldEmployee.getId());
                        break;
                }
                employee = createDecorator(company, idEmployee, newTypeEmployee, oldEmployee);

                switch (newTypeEmployee) {
                    case MANAGER:
                        if (listWorkers != null) {
                            for (int worker : listWorkers)
                                bindWorkerToManager(company, worker, employee.getId());
                        } else newRequest.setMessage("List of workers was empty");
                        break;
                    case WORKER:
                        if (idManager != 0)
                            bindWorkerToManager(company, employee.getId(), idManager);
                        else newRequest.setMessage("Id manager was null");
                        break;
                    case OTHER:
                        if (info != null)
                            ((DecoratorOther)employee).setInfo(info);
                        else newRequest.setMessage("Info was empty");
                        break;

                }
            } else newRequest.setMessage("Type of employee is the same like was");

            if (newRequest.getMessage() == null) newRequest.setMessage("Changing was successful");
        } else newRequest.setMessage("Id employee wasn't found");

        newRequest.setCompany(company);
        return newRequest;
    }

    private TypeEmployee definiteType(Employee employee){
        if (employee instanceof Manager)
            return TypeEmployee.MANAGER;
        else if (employee instanceof Worker)
            return TypeEmployee.WORKER;
        else return TypeEmployee.OTHER;
    }

    private Employee createDecorator(Company company, Integer idEmployee,TypeEmployee newTypeEmployee,Employee oldEmployee){
        Employee employee = DecoratorFactory.getInstance().createEmployee(newTypeEmployee, oldEmployee);
        company.getMapOtherOrManagerOrWorker().put(idEmployee,employee);//update link
        return employee;
    }

    @Override
    public NewRequest bindWorkerToManager(Company company, int worker, int managerId){

        NewRequest newRequest = factory.createResult();
        if (company.getWorkersOfManagerMap().containsKey(worker))
            unbindWorkerFromManager(company, worker);
        Employee manager = findEmployee(company, managerId);
        if (manager != null && manager instanceof Manager) {
            if (((Manager) manager).getListWorkers() == null) {
                ListWorkers listWorkers = factory.createListWorkers();
                ((Manager) manager).setListWorkers(listWorkers);
            }
            ((Manager) manager).getListWorkers().getWorkerId().add(worker);
            company.getWorkersOfManagerMap().put(worker, manager.getId());

            newRequest.setMessage("Binding was successful");
            newRequest.setCompany(company);
        }else {
            newRequest.setError("Error");
            newRequest.setMessage("Employee wasn't found");
        }
        return newRequest;
    }

    private Employee findEmployee(Company company,int id){
        return company.getMapOtherOrManagerOrWorker().get(id);
    }

}
