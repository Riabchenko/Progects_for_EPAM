package com.intellect25.notebook.view;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * The MyReader class
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class MyReader {

    /**
     * The method reads integer input
     *
     * @return result
     */
    static public LinkedList<?> start() {
        LinkedList resultList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            resultList.add(sc.nextInt());
        }else if (sc.hasNextLine()){
            resultList.add(sc.nextLine());
        }
        return resultList;
    }
}
