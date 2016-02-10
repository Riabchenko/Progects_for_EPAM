package com.intellect25.notebook;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by apple on 10/26/15.
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
