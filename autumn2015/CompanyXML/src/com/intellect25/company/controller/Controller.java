package com.intellect25.company.controller;

import com.intellect25.company.controller.reception.Factory;

/**
 * Created by apple on 1/20/16.
 */
public class Controller {

    public void post(){
        Factory.getInstance().createReception().menu();
    }
}
