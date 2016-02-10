package com.intellect25.controller;

import com.intellect25.view.Writer;

/**
 * General Controller for project
 *
 * @author Riabchenko Aliona
 */
public class Controller {

    /**
     * Private constructor
     */
    private Controller() {
    }

    /**
     * Get instance from this class
     *
     * @return instance from this class
     */
    public static Controller getInstance(){
        return new Controller();
    }

    /**
     * Create Dispatcher,run it and display result
     */
    public void doTask() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.run();
        Writer.display(dispatcher.getResult());
    }
}
