package com.intellect25.notebook.view;

import java.util.LinkedList;

/**
 * The MyWriter class display text
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class MyWriter {

    /**
     * Print String to standard output
     *
     * @param text  tex for displaying
     */
    public static void show(String text){
        System.out.println(text);
    }


    /**
     * Print list to standard output
     *
     * @param list list for displaying
     */
    public static void show(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
