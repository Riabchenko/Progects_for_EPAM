package com.intellect25.company.controller.command.commands;

import com.intellect25.company.controller.command.Command;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.Session;

/**
 * Created by apple on 1/18/16.
 */
public class DeleteEmployee extends Command {

    @Override
    public NewRequest execute(Session session, NewRequest request) {
        return facade.deleteEmployee(session.getObject(),request.getId());
    }
}
