package com.intellect25.company.controller.sesionRequest;

import com.intellect25.company.entity.interfaceObject.Company;
import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.object.TypeEmployee;
import com.intellect25.company.model.TypeSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by apple on 1/13/16.
 */
public class NewRequestImpl implements NewRequest {
    private int idManager;
    private List<Integer> list;
    private StringBuilder message;
    private String pathToFile;
    private String error;
    private Integer id;
    private Employee employee;
    private Company company;
    private TypeSort typeSort;

    /* data for new employee*/
    private String firstName;
    private String middleName;
    private String  lastName;
    private String birthday;
    private String dateOfGetJob;
    private String info;
    private TypeEmployee type;


    private List<Integer> workerId = new LinkedList<>();


    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public List<Integer> getList() {
        if (list == null)
            this.list = new ArrayList<>();
        return list;
    }

    @Override
    public void setList(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    @Override
    public StringBuilder getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        if (this.message == null)
            this.message = new StringBuilder();
        this.message.append(message);
        this.message.append("\n");
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String getPathToFile() {
        return pathToFile;
    }

    @Override
    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public TypeSort getTypeSort() {
        return typeSort;
    }

    @Override
    public void setTypeSort(TypeSort typeSort) {
        this.typeSort = typeSort;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getDateOfGetJob() {
        return dateOfGetJob;
    }

    @Override
    public void setDateOfGetJob(String dateOfGetJob) {
        this.dateOfGetJob = dateOfGetJob;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public TypeEmployee getType() {
        return type;
    }

    @Override
    public void setType(TypeEmployee type) {
        this.type = type;
    }

    @Override
    public int getIdManager() {
        return idManager;
    }

    @Override
    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    @Override
    public List<Integer> getWorkerId() {
        return workerId;
    }

    @Override
    public void setWorkerId(List<Integer> workerId) {
        this.workerId = workerId;
    }

}
