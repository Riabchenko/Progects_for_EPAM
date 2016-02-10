package com.intellect25.testSort;

import com.intellect25.sort.Heap;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * The HeapTest class tests methods for heapsorting
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class HeapTest extends TestCase {
    private Comparable[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new Comparable[]{"aaaaa", "bbbbb", "cccccc"};
        // shuffle
        Collections.shuffle(Arrays.asList(numbers));
    }

    @Test
    public void testNull() throws Exception {
        String[] b = new String[SIZE];
        Heap.sort(b);
        show(b);
    }

    @Test
    public void testEmpty() {
        Heap.sort(new String[SIZE]);
    }

    @Test
    public void testSimpleElement() {
        Comparable[] test = new Comparable[1];
        test[0] = 5;
        Heap.sort(test);
    }

    @Test
    public void testSpecial() {
        String[] test = {"rrrrr", "oooooo", "uuuu", "eee", "qqqqq", "iuiuiuiu", "aaaaaa", "ccccc"};
        Heap.sort(test);
        if (!Heap.isSorted(test)) {
            fail("Shouldn't happen");
        }
        show(test);
    }

    @Test
    public void testQuickSort() {
        for (Comparable i : numbers) {
            System.out.println(i + " ");
        }
        long startTime = System.currentTimeMillis();

        Heap.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!Heap.isSorted(numbers)) {
            fail("Shouldn't happen");
        }
        assertTrue(true);
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


}