package com.epam.task.game;

/**
 * Class creates instance of ReceptionImpl .
 *
 * @author Aliona Riabchenko
 * @version 1.01 19 Oct 2015
 */
public class Factory {

    private Factory(){}

    public static Reception createNewGame(){
        return new ReceptionImpl();
    }
}
