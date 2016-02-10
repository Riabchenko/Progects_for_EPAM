package com.intellect25.company.controller.reception;

import com.intellect25.company.controller.Controller;
import com.intellect25.company.controller.command.*;
import com.intellect25.company.controller.command.commands.*;
import com.intellect25.company.controller.menu.ChoiceMenus;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.NewRequestImpl;
import com.intellect25.company.controller.sesionRequest.Session;
import com.intellect25.company.controller.sesionRequest.SessionImpl;
import com.intellect25.company.view.Reader;
import com.intellect25.company.view.Writer;

/**
 * Created by apple on 1/20/16.
 */
public class Factory {
    private static Factory factory;

    private Factory() {
    }

    public static Factory getInstance(){
        if (factory==null)
            factory = new Factory();
        return factory;
    }

    public NewRequest createNewRequest(){
        return new NewRequestImpl();
    }

    public ManagerCommand createManagerCommand(){
        return new ManagerCommand();
    }

    public Command createCommand(ChoiceMenus choiceMenus){
        switch (choiceMenus){
            case CHANGE_TYPE_OF_EMPLOYEE:
                return new ChangeTypeEmployee();
            case CREATE_XML:
                return new CreateXML();
            case DELETE_EMPLOYEE:
                return new DeleteEmployee();
            case BIND_EMPLOYEE_TO_MANAGER:
                return new ManagerForWorker();
            case SET_NEW_EMPLOYEE:
                return new SetNewEmployee();
            case SORT:
                return new Sort();

            default:
                throw new NullPointerException("Error");
        }
    }

    public Command createParserDocument(){
        return new ParserDocument();
    }

    public Writer createWriter(){
        return new Writer();
    }

    public Reader createReader(){
        return new Reader();
    }

    public Session createSession(){
        return new SessionImpl();
    }

    public Reception createReception(){
        return new ReceptionImpl();
    }

    public Controller createController(){
        return new Controller();
    }
}
