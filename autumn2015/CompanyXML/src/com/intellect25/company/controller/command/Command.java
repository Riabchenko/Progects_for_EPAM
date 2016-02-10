package com.intellect25.company.controller.command;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.Session;
import com.intellect25.company.model.Facade;
import com.intellect25.company.model.FacadeImpl;

/**
 * Created by apple on 12/1/15.
 */
public abstract class Command {
    protected Facade facade = FacadeImpl.getInstance();
    public abstract NewRequest execute(Session session, NewRequest request);

}
