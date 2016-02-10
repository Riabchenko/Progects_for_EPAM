package com.intellect25.controller;

/**
 * Factory fo controller
 *
 * @author Riabchenko Aliona
 */
public class Factory {

    /** Instance of factory */
    private static Factory factory;

    /**
     * Get instance of Factory
     *
     * @return Factory
     */
    public static Factory getInstance(){
        if (factory == null)
            factory = new Factory();
        return factory;
    }

    /**
     * Create controller
     *
     * @return Controller
     */
    public Controller create(){
        return new Controller();
    }
}
