package com.intellect25.company.controller.command.commands;

import com.intellect25.company.controller.command.Command;
import com.intellect25.company.controller.reception.Message;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.NewRequestImpl;
import com.intellect25.company.controller.sesionRequest.Session;

/**
 * Created by apple on 1/18/16.
 */
public class Sort extends Command implements Message {

    @Override
    public NewRequest execute(Session session, NewRequest request) {
        if (request.getTypeSort() != null) {
            NewRequest newRequest = facade.sortBy(session.getObject(), request.getTypeSort());
            session.setObject(newRequest.getCompany());
            return newRequest;
        }
        else {
            request = new NewRequestImpl();
            request.setMessage(ERROR_NULL);
            return request;
        }
    }
}
