package com.intellect25.company.controller.command.commands;

import com.intellect25.company.controller.command.Command;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.Session;

/**
 * Created by apple on 1/19/16.
 */
public class ChangeTypeEmployee extends Command {
    @Override
    public NewRequest execute(Session session, NewRequest request) {
        NewRequest newRequest = facade.changeTypeOfEmployee(session.getObject(), request.getId(), request.getType(),
                request.getList(),request.getIdManager(),request.getInfo());
        session.setObject(newRequest.getCompany());
        return newRequest;
    }

}
