package com.intellect25.company.controller.sesionRequest;

import com.intellect25.company.entity.interfaceObject.Company;

/**
 * Created by apple on 1/18/16.
 */
public interface Session {
    int getId();

    void setId(int id);

    Company getObject();

    void setObject(Company object);
}
