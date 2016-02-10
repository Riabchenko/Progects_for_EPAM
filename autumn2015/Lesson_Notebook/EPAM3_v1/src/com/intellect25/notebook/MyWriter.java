package com.intellect25.notebook;

import java.util.LinkedList;

/**
 * The MyWriter class display text
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class MyWriter {

    /**
     * print String to standard output
     */
    public static void show(String text){
        System.out.println(text);
    }

    /**
     * print list to standard output
     */
    public static void show(LinkedList a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
