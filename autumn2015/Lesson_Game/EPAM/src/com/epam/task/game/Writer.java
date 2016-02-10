package com.epam.task.game;

/**
 * Class for a output result.
 *
 * @author Aliona Riabchenko
 * @version 1.00 17 Oct 2015
 */
public class Writer {

    /**
     * The method outputs errors
     *
     * @param number entered number
     * @param message message for displaying
     */
    static public void say(Integer number, String message) {
        System.out.println(number + " - " + message);
    }

    /**
     * The method outputs messages
     *
     * @param message message for displaying
     */
    static public void message(String message) {
        System.out.println(message);
    }
}
