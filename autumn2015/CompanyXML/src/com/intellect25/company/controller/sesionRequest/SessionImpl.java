package com.intellect25.company.controller.sesionRequest;

import com.intellect25.company.entity.interfaceObject.Company;

/**
 * Created by apple on 1/18/16.
 */
public class SessionImpl implements Session {
    private int id;
    private Company object;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Company getObject() {
        return object;
    }

    @Override
    public void setObject(Company object) {
        this.object = object;
    }
}
