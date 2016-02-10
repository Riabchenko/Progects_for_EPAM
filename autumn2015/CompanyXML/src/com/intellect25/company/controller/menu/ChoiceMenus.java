package com.intellect25.company.controller.menu;

/**
 * Created by apple on 1/18/16.
 */
public enum ChoiceMenus {
    CONTINUE("1 - CONTINUE"),
    EXIT("2 - EXIT"),
    SET_NEW_EMPLOYEE("3 - SET NEW EMPLOYEE"),
    SORT("4 - SORT"),
    DELETE_EMPLOYEE("5 - DELETE EMPLOYEE"),
    CHANGE_TYPE_OF_EMPLOYEE("6 - CHANGE TYPE OF EMPLOYEE"),
    BIND_EMPLOYEE_TO_MANAGER("7 - BIND EMPLOYEE TO MANAGER"),
    GIVE_EMPLOYEE_TO_MANAGE("8 - GIVE EMPLOYEE TO MANAGER"),
    CREATE_XML("9 - CREATE XML");

    private String nameMenu;

    ChoiceMenus(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getNameMenu(){
        return nameMenu;
    }
}
