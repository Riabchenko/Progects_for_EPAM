package com.intellect25;

import com.intellect25.controller.Factory;

/**
 * Client
 *
 * @author Riabchenko Aliona
 */
public class Main {

    /**
     *  Start client
     *
     * @param args input data
     */
    public static void main(String[]args) {
        Factory.getInstance().create().start();
    }

}
