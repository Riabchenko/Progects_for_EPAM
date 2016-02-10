package com.intellect25.company.controller.command;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.NewRequestImpl;
import com.intellect25.company.controller.sesionRequest.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 12/1/15.
 */
public class ManagerCommand {
    private List<Command> eventList = new ArrayList<>();

    public void setCommand(Command command){
        this.eventList.add(command);
    }

        public NewRequest execute(Session session,NewRequest request){
            NewRequest newRequest = new NewRequestImpl();
            while (eventList.size() > 0){
                for (Command event : new ArrayList<Command>(eventList)){
                    newRequest = event.execute(session,request);
                    eventList.remove(event);
                }
            }
            return newRequest;
    }
}
