package com.intellect25.company.controller.reception;

import com.intellect25.company.controller.command.ManagerCommand;
import com.intellect25.company.controller.menu.ChoiceMenus;
import com.intellect25.company.controller.menu.ChoiceMenusSort;
import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.Session;
import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.interfaceObject.Manager;
import com.intellect25.company.entity.interfaceObject.Worker;
import com.intellect25.company.entity.object.TypeEmployee;
import com.intellect25.company.view.Reader;
import com.intellect25.company.view.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by apple on 1/18/16.
 */
public class ReceptionImpl implements Message, Reception {

    private int flag;
    private final int CONTINUE_WORK = 1;
    private final int STOP_WORK = 2;

    private Factory factory = Factory.getInstance();
    private Session session  = factory.createSession();
    private Reader reader = factory.createReader();
    private Writer writer = factory.createWriter();

    @Override
    public void menu(){
        do {

            writer.printStrLN(BEGIN);

            ChoiceMenus[] choices = ChoiceMenus.values();
            for(ChoiceMenus menus : choices) {
                writer.printStrLN(menus.getNameMenu());
            }
            writer.printStr(SELECT);

            /* number begin from 0, therefore must -1*/
            int numberChoiceMenus = reader.readInt(CONTINUE_WORK, choices.length ) - 1;


            ChoiceMenus choiceMenus = null;
            if (numberChoiceMenus > 0) choiceMenus = choices[numberChoiceMenus];

            if (choiceMenus != null) {
                switch (choiceMenus) {
                    case SORT:
                        sortBy();
                        break;
                    case CREATE_XML:
                        createXML();
                        break;
                    case SET_NEW_EMPLOYEE:
                        setNewEmployee();
                        break;
                    case DELETE_EMPLOYEE:
                        deleteEmployee();
                        break;
                    case BIND_EMPLOYEE_TO_MANAGER:
                        bindEmployeeToManager();
                        break;
                    case CHANGE_TYPE_OF_EMPLOYEE:
                        changeTypeEmployee();
                        break;
                    default:
                        throw new NullPointerException(ERROR);


                }
                exit();
            } else {
                writer.printStr(REPEAT);
                menu();
            }
        } while (flag == CONTINUE_WORK);
        session = null;
    }

    private void changeTypeEmployee() {
        ManagerCommand managerCommand = factory.createManagerCommand();
        boolean worker = false;
        if(parseDocument()){
            NewRequest request = factory.createNewRequest();
            int idWorker = 0;
            do {
            writer.printStr(ID);
                idWorker = reader.readInt();
                if (isEmployeeInCompany(idWorker)) {
                    request.setId(idWorker);
                    worker = true;
            }
            }while (!worker);
            writer.printStrLN(NEW_TYPE);
            TypeEmployee[]typeEmployees = TypeEmployee.values();
            for (TypeEmployee typeEmployee:typeEmployees){
                writer.printStrLN(typeEmployee.getValue());
            }
            writer.printStr(SELECT);

            int numberMenu = reader.readInt(CONTINUE_WORK,typeEmployees.length)-1;

            NewRequest after = addQuestions(typeEmployees[numberMenu],
                    session.getObject().getMapOtherOrManagerOrWorker().get(idWorker),managerCommand);
            if (after.getError() == null) {
                managerCommand.setCommand(factory.createCommand(ChoiceMenus.CHANGE_TYPE_OF_EMPLOYEE));
                NewRequest newRequest = managerCommand.execute(session, after);
                if (newRequest.getError() != null) writer.printStrLN(newRequest.getError());
                writer.printStrLN(newRequest.getMessage().toString());
            } else writer.printStrLN(after.getError());
        }
    }
    private NewRequest addQuestions(TypeEmployee newTypeEmployee,Employee oldEmployee,ManagerCommand managerCommand){
        NewRequest newRequest = factory.createNewRequest();
        newRequest.setId(oldEmployee.getId());
        TypeEmployee typeOldEmployee = definiteType(oldEmployee);
        if (!newTypeEmployee.equals(typeOldEmployee)) {
            newRequest.setType(newTypeEmployee);
            switch (typeOldEmployee) {
                case MANAGER:
                    newRequest = unbindManagerFromEmployee(oldEmployee, newRequest,managerCommand);
                    break;
            }

            switch (newTypeEmployee) {
                case MANAGER:
                    newRequest = changeToManager(newRequest);
                    break;
                case WORKER:
                    newRequest = changeToWorker(newRequest);
                    break;
                case OTHER:
                    newRequest = setInfo(newRequest);
                    break;
            }
        } else newRequest.setError(TYPE_IS_LIKE_SAME);
        return newRequest;
    }

    private NewRequest unbindManagerFromEmployee(Employee oldEmployee,NewRequest newRequest,ManagerCommand managerCommand){
        List<Integer> list = ((Manager) oldEmployee).getListWorkers().getWorkerId();
        newRequest.setList(list);
        writer.printStr(DIFFERENCE_MANAGER);
        String temp = reader.readString();
        appointManager(temp, newRequest, managerCommand);
        return newRequest;
    }

    private NewRequest setInfo(NewRequest newRequest){
        writer.printStr(ENTER_INFO);
        newRequest.setInfo(reader.readString());
        return newRequest;
    }

    private NewRequest changeToWorker(NewRequest newRequest){
        writer.printStr(ENTER_ID_MANAGER_WHO_TAKE_WORKERS);
        boolean is = false;
        int workersId = 0;
        do {
            workersId = reader.readInt();
            if (isEmployeeInCompany(workersId) && isManager(workersId) && workersId != newRequest.getId()) is = true;
            else writer.printStr(REPEAT);
        } while (!is);
        newRequest.setIdManager(workersId);
        return newRequest;
    }
    private NewRequest changeToManager(NewRequest newRequest){
        writer.printStrLN(APPOINT_WORKERS_FOR_MANAGER);
        String answer = reader.readString();
        while (answer.compareToIgnoreCase("y")== 0) {
            writer.printStr(CHOSE_WORKER_FOR_MANAGER);
            boolean is = false;
            int workersId = 0;
            do {
                workersId = reader.readInt();
                if (isEmployeeInCompany(workersId) && isWorker(workersId) && workersId != newRequest.getId()) is = true;
                else writer.printStr(REPEAT);
            } while (!is);
            newRequest.getList().add(workersId);
            writer.printStr(CONTINUE);
            answer = reader.readString();
        } writer.printStrLN(TYPE_CHANGE_SUCCESS);
        return newRequest;
    }


    private TypeEmployee definiteType(Employee employee){
        if (employee instanceof Manager)
            return TypeEmployee.MANAGER;
        else if (employee instanceof Worker)
            return TypeEmployee.WORKER;
        else return TypeEmployee.OTHER;
    }

    private boolean isManager(int id){
        return session.getObject().getMapOtherOrManagerOrWorker().get(id) instanceof Manager;
    }
    private boolean isWorker(int id){
        return session.getObject().getMapOtherOrManagerOrWorker().get(id) instanceof Worker;
    }

    private boolean isEmployeeInCompany(int id){
        return session.getObject().getMapOtherOrManagerOrWorker().containsKey(id);
    }

    private void bindEmployeeToManager() {
        ManagerCommand managerCommand = factory.createManagerCommand();
        boolean worker = false;
        boolean manager = false;
        if(parseDocument()){
            NewRequest request = factory.createNewRequest();
            do {
                writer.printStr(ENTER_ID_WORKER);
                int idWorker = reader.readInt();
                if (isEmployeeInCompany(idWorker)) {
                    if (isWorker(idWorker)) {
                        worker = true;
                        request.setEmployee(session.getObject().getMapOtherOrManagerOrWorker().get(idWorker));
                    }
                }
            }while (!worker);

            do {
                writer.printStr(ENTER_ID_MANAGER);
                int idManager = reader.readInt();
                if (isEmployeeInCompany(idManager)) {
                    if (isManager(idManager)) {
                        manager = true;
                        request.setIdManager(idManager);
                    }
                }
            }while (!manager);

            managerCommand.setCommand(factory.createCommand(ChoiceMenus.BIND_EMPLOYEE_TO_MANAGER));
            NewRequest newRequest = managerCommand.execute(session, request);
            if (newRequest.getError()!= null) writer.printStrLN(newRequest.getError());
            writer.printStrLN(newRequest.getMessage().toString());
        }
    }

    private boolean exit(){
    writer.printStrLN(CONTINUE_EXIT);
    flag = reader.readInt(CONTINUE_WORK, STOP_WORK);
    return flag==1;
    }
    private void deleteEmployee() {
        ManagerCommand managerCommand = factory.createManagerCommand();
        if(parseDocument()){
            NewRequest request = factory.createNewRequest();
            writer.printStr(ENTER_ID_FOR_DELETE);
            request.setId(reader.readInt());
            managerCommand.setCommand(factory.createCommand(ChoiceMenus.DELETE_EMPLOYEE));
            NewRequest newRequest = managerCommand.execute(session, request);
            writer.printStrLN(newRequest.getMessage().toString());

            if (newRequest.getList() != null) {
                writer.printList(newRequest.getList());
                writer.printStrLN(DIFFERENCE_MANAGER);
                appointManager(reader.readString(), newRequest, managerCommand);
            }
        }
    }

    private void appointManager(String temp,NewRequest newRequest,ManagerCommand managerCommand) {
        Map<Integer, Employee> map = session.getObject().getMapOtherOrManagerOrWorker();
        List<Integer> list = newRequest.getList();
        while (temp.compareToIgnoreCase("y") == 0) {
            for (int i = 0; i < list.size(); ) {
                writer.printStr(ENTER_ID_FOR_WORKER_ID + list.get(i));
                int idManager = reader.readInt();

                if (map.containsKey(idManager) && isManager(idManager)) {
                    managerCommand.setCommand(factory.createCommand(ChoiceMenus.BIND_EMPLOYEE_TO_MANAGER));
                    NewRequest requestForBind = factory.createNewRequest();
                    requestForBind.setIdManager(idManager);
                    requestForBind.setEmployee(map.get(list.get(i)));
//                    managerCommand.setCommand(factory.createCommand(ChoiceMenus.BIND_EMPLOYEE_TO_MANAGER));
                    NewRequest requestAfterBind = managerCommand.execute(session, requestForBind);
                    if (requestAfterBind.getError() == null) {
                        session.setObject(requestAfterBind.getCompany());
                        writer.printStrLN(requestAfterBind.getMessage().toString());
                        list.remove(i);
                    } else writer.printStrLN(MANAGER_NOT_FOUND);
                }else writer.printStrLN(MANAGER_NOT_FOUND);
            }
            if (list.size()>0) {
                writer.printStrLN(CONTINUE);
                temp = reader.readString();
            }else break;
        }
            if (temp.compareToIgnoreCase("n") == 0 && list.size() > 0) {
                writer.printStr(ENTER_ID_MANAGER_FOR_REMAIN + list.size() + WORKERS);
                int idForRemain = reader.readInt();
                    while (list.size() > 0) {
                        for (int i = 0; i < list.size(); ) {
                            NewRequest requestForBind = factory.createNewRequest();
                            requestForBind.setIdManager(idForRemain);
                            requestForBind.setEmployee(map.get(list.get(i)));
                            managerCommand.setCommand(factory.createCommand(ChoiceMenus.BIND_EMPLOYEE_TO_MANAGER));
                            NewRequest newRequestAfter = managerCommand.execute(session, requestForBind);
                            if (newRequestAfter.getError() == null) {
                                session.setObject(newRequestAfter.getCompany());
                                list.remove(i);
                            } else {
                                writer.printStrLN(MANAGER_NOT_FOUND);
                                idForRemain = reader.readInt();
                            }
                        }
                    }
                writer.printStrLN(OK);
            }

    }

    private void setNewEmployee() {
        ManagerCommand managerCommand = factory.createManagerCommand();
        if(parseDocument()){
            String temp = null;
            NewRequest request = factory.createNewRequest();
            writer.printStrLN(ENTER_INFORMATION);

            writer.printStr(ID);
            int id = reader.readInt();
            request.setId(id);

            writer.printStr(LAST_NAME);
            temp = reader.readString();
            request.setLastName(temp);

            writer.printStr(FIRST_NAME);
            temp = reader.readString();
            request.setFirstName(temp);

            writer.printStr(MIDDLE_NAME);
            temp = reader.readString();
            request.setMiddleName(temp);

            writer.printStr(BIRTHDAY);
            String dayStr = getValueOfDate();
            String month = getValueOfMonth();
            String year = getValueOfYear();

            String birthday = year+"-"+month+"-"+dayStr;
            request.setBirthday(birthday);

            writer.printStr(DATE_GET_JOB);
            String dayJobStr = getValueOfDate();
            String monthJob = getValueOfMonth();
            String yearJob =getValueOfYear();

            String dateJob = yearJob+"-"+monthJob+"-"+dayJobStr;
            request.setDateOfGetJob(dateJob);

            writer.printStrLN(CHOSE_TYPE_EMPLOYEE);
            TypeEmployee[]typeEmployees = TypeEmployee.values();
            for (TypeEmployee typeEmployee:typeEmployees)
                writer.printStrLN(typeEmployee.getValue());
            int numberMenu = reader.readInt(CONTINUE_WORK,typeEmployees.length)-1;
            if (numberMenu >= 0){
                if(numberMenu <= typeEmployees.length){
                    request.setType(typeEmployees[numberMenu]);
                } else if (numberMenu == 1) {
                    menu();
                }else  if (numberMenu == 2) {
                    flag = 2;
                }else {
                    writer.printStrLN(REPEAT);
                }
            }
            switch (typeEmployees[numberMenu]){
                case MANAGER:
                    addWorkerToManager(request);
                    break;
                case WORKER:
                    addManagerToWorker(request);
                    break;
                case OTHER:
                    writer.printStr(INFO);
                    temp = reader.readString();
                    request.setInfo(temp);
                    break;
            }

            managerCommand.setCommand(factory.createCommand(ChoiceMenus.SET_NEW_EMPLOYEE));
            NewRequest newRequest = managerCommand.execute(session,request);
            writer.printStrLN(newRequest.getMessage().toString());

        }
    }

    private String getValueOfDate(){
        return createDate(DAY,31);
    }

    private String getValueOfMonth(){
        return createDate(MONTH,12);
    }

    private String createDate(String value, int high){
        writer.printStr(value);
        int day = 0;
        day = reader.readInt(1,high);
        String dayStr = null;
        if (day<10) dayStr = "0"+day;
        else dayStr = String.valueOf(day);
        return dayStr;
    }

    private String getValueOfYear(){
        writer.printStr(YEAR);
        String yearJob = reader.readString();
        Pattern datePattern = Pattern.compile("\\d{4}");
        Matcher dateMatcher = datePattern.matcher(yearJob);
        if (!dateMatcher.find()){
            yearJob = getValueOfYear();
        }
//        Pattern datePattern = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        return yearJob;
    }

    private void addManagerToWorker(NewRequest request) {
        writer.printStr(ENTER_ID_FOR_WORKER_ID);
        int id = reader.readInt();
        request.setIdManager(id);
    }

    private void addWorkerToManager(NewRequest request) {
        writer.printStrLN(APPOINT_WORKERS_FOR_MANAGER);
        String temp = reader.readString();
        List<Integer> list = new ArrayList<>();
        while (temp.compareToIgnoreCase("y")==0){
            int idWorker = 0;
            boolean worker = false;
            do {
                writer.printStr(ENTER_ID_WORKER);
                idWorker = reader.readInt();
                if (isEmployeeInCompany(idWorker)) {
                    if (isWorker(idWorker)) {
                        worker = true;
                        request.setEmployee(session.getObject().getMapOtherOrManagerOrWorker().get(idWorker));
                    }
                }
                if(!worker) writer.printStr(REPEAT);
            }while (!worker);
            list.add(idWorker);

            writer.printStrLN(ADD_WORKER);
            temp = reader.readString();
        }
        if (list.size() > 0) request.setList(list);

    }

    private void createXML() {
        ManagerCommand managerCommand = factory.createManagerCommand();
       if(parseDocument()){
           writer.printStr(WRITE_PATH_TO_NEW_XML);
           String path = reader.readString();
           NewRequest request = factory.createNewRequest();
           request.setPathToFile(path);
           managerCommand.setCommand(factory.createCommand(ChoiceMenus.CREATE_XML));
           NewRequest newRequest = managerCommand.execute(session,request);
           if (newRequest.getError() != null)
               writer.printStrLN(newRequest.getError());
           else writer.printStrLN(newRequest.getMessage().toString());
       } else {
           writer.printStrLN(REPEAT);
           createXML();
       }

    }

    private void sortBy() {
        ManagerCommand managerCommand = factory.createManagerCommand();

        if (parseDocument()) {
            ChoiceMenusSort[] menusSorts = ChoiceMenusSort.values();
            for (ChoiceMenusSort menusSort : menusSorts) {
                writer.printStrLN(menusSort.getNameMenu());
            }

            writer.printStr(SELECT);

            /* number begin from 0, therefore must -1*/
            int numberMenusSorts = reader.readInt(CONTINUE_WORK,menusSorts.length) - 1;


            NewRequest request = factory.createNewRequest();
                request.setTypeSort(menusSorts[numberMenusSorts].getTypeSort());

                managerCommand.setCommand(factory.createCommand(ChoiceMenus.SORT));
                NewRequest newRequest = managerCommand.execute(session, request);
                session.setObject(newRequest.getCompany());
                writer.printStrLN(EMPLOYEE_WERE_SORTED);

        } else writer.printStrLN(NOT_FOUND_FILE);
    }

    private boolean parseDocument(){
        boolean fileIs = true;
        if (session.getObject() == null) {
            ManagerCommand managerCommand = factory.createManagerCommand();
            writer.printStr(WRITE_PATH_TO_XML);
            String path = reader.readString();
            NewRequest request = factory.createNewRequest();
            request.setPathToFile(path);
            managerCommand.setCommand(factory.createParserDocument());
            NewRequest newRequest = managerCommand.execute(session, request);
            if (newRequest.getError() != null) {
                fileIs = false;
            } else session.setObject(newRequest.getCompany());
        }
        return fileIs;
    }
}
