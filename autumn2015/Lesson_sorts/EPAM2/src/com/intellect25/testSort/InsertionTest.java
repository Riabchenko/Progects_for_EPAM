package com.intellect25.testSort;

import com.intellect25.sort.Insertion;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * The InsertionTest class tests methods for insert sorting
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class InsertionTest extends TestCase {
    private Comparable[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;

    @Before
    public void setUp() throws Exception {
        numbers = new Comparable[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
        // shuffle
        Collections.shuffle(Arrays.asList(numbers));
    }

    @Test
    public void testNull() throws Exception {
        String[] b = new String[SIZE];
        Insertion.sort(b);
        show(b);
    }

    @Test
    public void testEmpty() {
        Insertion.sort(new String[0]);
    }

    @Test
    public void testSimpleElement() {
        Comparable[] test = new Comparable[1];
        test[0] = 5;
        Insertion.sort(test);
    }

    @Test
    public void testSpecial() {
        String[] test = {"rrrrr", "oooooo", "uuuu", "eee", "qqqqq", "iuiuiuiu", "aaaaaa", "ccccc"};
        Insertion.sort(test);
        show(test);
    }

    public void testSort() throws Exception {
        for (Comparable i : numbers) {
            System.out.println(i + " ");
        }
        long startTime = System.currentTimeMillis();

        Insertion.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Insertion " + elapsedTime);
        show(numbers);
        assertTrue(true);
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}