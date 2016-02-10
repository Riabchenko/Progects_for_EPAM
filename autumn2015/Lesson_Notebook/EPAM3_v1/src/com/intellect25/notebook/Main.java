package com.intellect25.notebook;

/**
 * The Main class
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class Main {
    /**
     * it's client
     *
     * @param args entered data
     */
    public static void main(String[]args){

        /* Count days to the birthday*/
        MyWriter.show(Factory.start(1983, 7, 9));

        /* Search all constructors and their parameters*/
        MyWriter.show(Factory.start(NoteBook.class));
        MyWriter.show(Factory.start(Day.class));
    }
}
