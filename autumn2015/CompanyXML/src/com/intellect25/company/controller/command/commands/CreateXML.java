package com.intellect25.company.controller.command.commands;

import com.intellect25.company.controller.command.Command;
import com.intellect25.company.controller.reception.Message;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.NewRequestImpl;
import com.intellect25.company.controller.sesionRequest.Session;

/**
 * Created by apple on 1/18/16.
 */
public class CreateXML extends Command implements Message {

    @Override
    public NewRequest execute(Session session, NewRequest request) {
        if (request.getPathToFile() != null) {
            return facade.createXML(request.getPathToFile(),session.getObject());
        }else {
            request = new NewRequestImpl();
            request.setMessage(ERROR_NULL);
            return request;
        }
    }
}
