package com.intellect25.company.entity.object;

/**
 * Created by apple on 1/11/16.
 */
public enum TypeEmployee {
    MANAGER("1 - MANAGER"),WORKER("2 - WORKER"),OTHER("3 - OTHER");

    private String value;

    TypeEmployee(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
