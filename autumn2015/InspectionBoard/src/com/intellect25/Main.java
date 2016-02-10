package com.intellect25;

import com.intellect25.controller.Controller;

/**
 * Client
 *
 * @author Riabchenko Aliona
 */
public class Main {

    /**
     * Start project
     *
     * @param args input data
     * @throws InterruptedException exception
     */
    public static void main(String[]args) throws InterruptedException {
        Controller.getInstance().doTask();
    }
}
