package com.intellect25;

import com.intellect25.controller.Controller;

import java.io.IOException;

/**
 * Client
 *
 * @author Riabchenko Aliona
 */
public class Main {

    /**
     * Execute the Controller
     *
     * @param args input data
     * @throws IOException error
     */
    public static void main(String[]args) throws IOException {
        Controller controller = new Controller();
        controller.execute();
    }
}
