package com.intellect25.company;

import com.intellect25.company.controller.reception.Factory;

/**
 * Created by apple on 1/12/16.
 */
public class Main {

    public static void main(String[] args) {
//        src/com/intellect25/company/resources/company.xml
//        src/com/intellect25/company/resources/test1.xml

        Factory.getInstance().createController().post();
    }


}
