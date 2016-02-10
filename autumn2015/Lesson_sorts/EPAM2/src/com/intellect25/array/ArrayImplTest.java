package com.intellect25.array;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by apple on 10/23/15.
 */
public class ArrayImplTest extends TestCase {
    private int[] numbers;
    private final static int SIZE = 7;
    private final static int MAX = 20;
    Array collectionSorts = new ArrayImpl();

    @Before
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
        // shuffle
        Collections.shuffle(Arrays.asList(numbers));
    }

    public void testSearchMaxElementValueIndex() throws Exception {
        int[] numbers = {4,6,13,6,-5,9};
        int[] result = new  int[2];
        result[0]=2;
        result[1]=13;

        assertArrayEquals(result, collectionSorts.searchMaxElementValueIndex(numbers));
    }

    public void testSearchMinElementValueIndex() throws Exception {
        int[] numbers = {4,6,13,6,-5,9};
        int[] result = new  int[2];
        result[0]=4;
        result[1]=-5;

        assertArrayEquals(result, collectionSorts.searchMinElementValueIndex(numbers));
    }

    public void testSearchMiddleValue() throws Exception {
        int[] numbers = {4,6,6,5,9};
        double result = (4+6+6+5+9)/5;

        assertEquals(result, collectionSorts.searchMiddleValue(numbers));
    }

    public void testCountElementIsZero() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int result = 2;

        assertEquals(result, collectionSorts.countElementIsZero(numbers));
    }

    public void testCountElementIsMoreZero() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int result = 5;

        assertEquals(result, collectionSorts.countElementIsMoreZero(numbers));
    }

    public void testMultiplicationElementNumber() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int k = 2;
        int[] result = new int[numbers.length];

        for(int i = 0; i < result.length;i++){
            result[i] = numbers[i]*k;
        }

        assertArrayEquals(result, collectionSorts.multiplicationElementNumber(numbers,k));
    }

    public void testSumElementAndIndex() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int[] result = new int[numbers.length];

        for(int i = 0; i < result.length;i++){
            result[i] = numbers[i]+i;
        }

        assertArrayEquals(result, collectionSorts.sumElementAndIndex(numbers));
    }

    public void testNullEven() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int[] result = {0,0,0,0,5,0,9};

        assertArrayEquals(result, collectionSorts.nullEven(numbers));
    }

    public void testNullNotEven() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int[] result = {4,6,0,6,0,0,0};

        assertArrayEquals(result, collectionSorts.nullNotEven(numbers));
    }

    public void testSearchFirstPositiveNumber() throws Exception {
        int[] numbers = {-4,-6,0,6,5,0,-9};
        int result = 6;

        assertEquals(result, collectionSorts.searchFirstPositiveNumber(numbers));
    }

    public void testSearchLastNegativeNumber() throws Exception {
        int[] numbers = {-4,-6,0,6,5,0,-9};
        int result = -9;

        assertEquals(result, collectionSorts.searchLastNegativeNumber(numbers));
    }

    public void testSearchIndexInputArray() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int k = 6;
        int[] result = {1,3,0,0,0,0,0};

        assertArrayEquals(result, collectionSorts.searchIndexInputArray(numbers, k));
    }

    public void testCheckingOrderedIncreasingArray() throws Exception {
        int[] numbers = {4,6,-1,6,5,0,9};

        assertTrue(collectionSorts.checkingOrderedIncreasingArray(numbers));
    }

    public void testCheckingOrderedDecreasingArray() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};

        assertTrue(collectionSorts.checkingOrderedDecreasingArray(numbers));
    }

    public void testMoveArrayRight() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int k = 2;
        int[] result = {0,9,4,6,0,6,5};

        assertArrayEquals(result, collectionSorts.moveArrayRight(numbers, k));
    }

    public void testSumArray() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int result = 30;
        assertEquals(result, collectionSorts.sumArray(numbers));
    }

    public void testSearchValueMoreNumber() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int result = 4;

        assertEquals(result, collectionSorts.searchValueMoreNumber(numbers));
    }

    public void testDisplayElementAreNotSecondArray() throws Exception {
        int[] numbersFirst = {4,6,9};
        int[] numbersSecond = {4,7,3};
        int[] result = {6,9,0,0,0,0};
//        show(collectionSorts.displayElementAreNotSecondArray(numbersFirst, numbersSecond));
        assertArrayEquals(result, collectionSorts.displayElementAreNotSecondArray(numbersFirst, numbersSecond));
    }

    public void testDisplayElementDublicate() throws Exception {
        int[] numbers = {4,6,9,9,9,4,5,8,7};
        int[] result = {4,9,9,9,0,0,0,0,0};
//        show(collectionSorts.displayElementDublicate(numbers));
        assertArrayEquals(result, collectionSorts.displayElementDublicate(numbers));
    }

    public void testDisplayNotElement() throws Exception {
        int[] numbers = {4,6,9,12,9,14,5,8,7};
        int[] result = {4,12,14,5,8,7,0,0,0};
//        show(collectionSorts.displayNotElement(numbers));
        assertArrayEquals(result, collectionSorts.displayNotElement(numbers));
    }

    public void testCountNeedElement() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int k = 6;
        int result = 2;
        assertEquals(result, collectionSorts.countNeedElement(numbers, k));
    }

    public void testCountSimilarlyValue() throws Exception {
        int[] numbers = {4,6,0,6,5,0,9};
        int result = 1;
//        showResult(collectionSorts.countSimilarlyValue(numbers));
        assertEquals(result, collectionSorts.countSimilarlyValue(numbers));
    }

    public void testThirdArrayFromTwoSortedArrays() throws Exception {
        int[] numbersOne = {1,2,3,4};
        int[] numbersTwo = {1,2,3,4};
        int[] result = {1,1,2,2,3,3,4,4};
//        show(collectionSorts.thirdArrayFromTwoSortedArrays(numbersOne,numbersTwo));
        assertArrayEquals(result, collectionSorts.thirdArrayFromTwoSortedArrays(numbersOne, numbersTwo));
    }

    public void testChangePositiveFirstLastAndOther() throws Exception {
        int[] numbers = {1,-2,3,4,5,6,7,8,9};
        int[] result = {9,-2,7,6,5,4,3,8,1};
//        show(collectionSorts.changePositiveFirstLastAndOther(numbers));
        assertArrayEquals(result, collectionSorts.changePositiveFirstLastAndOther(numbers));
    }

    // print array to standard output
    private void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // print result to standard output
    private static void showResult(int a) {
        System.out.println(a);
    }
}