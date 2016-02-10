package com.epam.task.game;

import java.util.Scanner;

/**
 * Class reads result.
 *
 * @author Aliona Riabchenko
 * @version 1.00 17 Oct 2015
 */
public class Reader {

    /**
     * The method reads integer input
     *
     * @return code of error/not error
     */
    static public int start() {
        int i = -1;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            i = sc.nextInt();
        }else if (sc.hasNextLine()){
            String str = sc.nextLine();
            if (str.compareToIgnoreCase("exit") == 0){
                i = -2;
            } else if (str.compareToIgnoreCase("y") == 0){
                i = -3;
            } else if (str.compareToIgnoreCase("n") == 0){
                i = -4;
            }
        }else{
            i = -1;
        }
        return i;
    }


}
