package com.intellect25.notebook;

import java.util.LinkedList;

/**
 * The Main class
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class Factory {

    /**
     * Private constructor
     */
    private Factory(){}

    /**
     * Count days to the birthday
     *
     * @param year year
     * @param month month
     * @param day day
     * @return list of result
     */
    public static LinkedList<String> start(int year,int month, int day) {
        return TrackerConstructor.trackMethod(NoteBook.class, year, month, day);
    }

    /**
     * Search all constructors and their parameters
     *
     * @param enteredClass entered class
     * @return list of result
     */
    public static LinkedList<String> start(Class enteredClass) {
        return TrackerConstructor.constructorSearch(NoteBook.class);
    }

}
