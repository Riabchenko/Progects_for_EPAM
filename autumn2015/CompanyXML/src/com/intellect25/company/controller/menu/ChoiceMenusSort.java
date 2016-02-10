package com.intellect25.company.controller.menu;

import com.intellect25.company.model.TypeSort;

/**
 * Created by apple on 1/18/16.
 */
public enum ChoiceMenusSort {

    SORT_BY_ID("1 - SORT BY ID", TypeSort.BY_ID),
    SORT_BY_LAST_NAME("2 - SORT BY LAST NAME",TypeSort.BY_LAST_NAME),
    SORT_BY_DATE_OF_GETTING_JOB("3 - SORT BY DATE OF GETTING JOB",TypeSort.BY_DATE_GET_JOB);


    private String nameMenu;
    private TypeSort typeSort;

    ChoiceMenusSort(String nameMenu, TypeSort typeSort) {
        this.nameMenu = nameMenu;
        this.typeSort = typeSort;
    }

    public String getNameMenu(){
        return nameMenu;
    }

    public TypeSort getTypeSort() {
        return typeSort;
    }
}
