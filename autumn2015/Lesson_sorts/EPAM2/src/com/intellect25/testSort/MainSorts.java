package com.intellect25.testSort;

import com.intellect25.sort.*;

import java.util.Arrays;
import java.util.Collections;

/**
 * Main class
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class MainSorts {
    /**
     * Reads in a sequence of strings from standard input; insertion sorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        Integer[] a = {2, 5, 8, 4, 6, 1, 0, 3};

        Insertion.sort(a);
        show(a);

        // shuffle
        Collections.shuffle(Arrays.asList(a));
        Quick.sort(a);
        show(a);

        // shuffle
        Collections.shuffle(Arrays.asList(a));
        Selection.sort(a);
        show(a);

        // shuffle
        Collections.shuffle(Arrays.asList(a));
        Merge.sort(a);
        show(a);

        // shuffle
        Collections.shuffle(Arrays.asList(a));
        Shell.sort(a);
        show(a);

        String[] b = {"aaaaa", "bbbbb", "cccccc"};
        Heap.sort(b);
        show(b);
    }


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
