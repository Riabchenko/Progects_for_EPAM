package com.intellect25.company.controller.sesionRequest;


import com.intellect25.company.entity.interfaceObject.Company;
import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.object.TypeEmployee;
import com.intellect25.company.model.TypeSort;

import java.util.List;

/**
 * Created by apple on 1/20/16.
 */
public interface NewRequest {
    Employee getEmployee();

    void setEmployee(Employee employee);

    List<Integer> getList();

    void setList(List<Integer> list);

    StringBuilder getMessage();

    void setMessage(String message);

    Integer getId();

    void setId(Integer id);

    Company getCompany();

    void setCompany(Company company);

    String getPathToFile();

    void setPathToFile(String pathToFile);

    TypeSort getTypeSort();

    void setTypeSort(TypeSort typeSort);

    String getError();

    void setError(String error);

    String getFirstName();

    void setFirstName(String firstName);

    String getMiddleName();

    void setMiddleName(String middleName);

    String getLastName();

    void setLastName(String lastName);

    String getBirthday();

    void setBirthday(String birthday);

    String getDateOfGetJob();

    void setDateOfGetJob(String dateOfGetJob);

    String getInfo();

    void setInfo(String info);

    TypeEmployee getType();

    void setType(TypeEmployee type);

    int getIdManager();

    void setIdManager(int idManager);

    List<Integer> getWorkerId();

    void setWorkerId(List<Integer> workerId);
}
