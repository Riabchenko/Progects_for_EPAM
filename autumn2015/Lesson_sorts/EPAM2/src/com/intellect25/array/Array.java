package com.intellect25.array;

/**
 * The Array interface
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public interface Array {

    /**
     * Search max element,value,index
     *
     * @param array entered array
     * @return array with max element,value,index
     */
    int[] searchMaxElementValueIndex(int array[]);

    /**
     * Search min element,value,index
     *
     * @param array entered array
     * @return array with min element,value,index
     */
    int[] searchMinElementValueIndex(int array[]);

    /**
     * Search a middle value
     *
     * @param array entered array
     * @return middle value
     */
    double searchMiddleValue(int[] array);

    /**
     *
     * @param array  entered array
     * @param number entered number for searching
     * @return  amount of elements
     */
    int countNeedElement(int[] array, int number);

    /**
     * Count elements which are zero
     *
     * @param array entered array
     * @return amount of elements
     */
    int countElementIsZero(int[] array);

    /**
     * Count elements which are more zero
     *
     * @param array entered array
     * @return amount of elements
     */
    int countElementIsMoreZero(int[] array);

    /**
     * Multiplication element to number
     *
     * @param array entered array
     * @param number number for multiplication
     * @return result array
     */
    int[] multiplicationElementNumber(int[] array, int number);

    /**
     * Add index to element of array
     *
     * @param array entered array
     * @return result array
     */
    int[] sumElementAndIndex(int [] array);

    /**
     * Reset even numbers
     *
     * @param array entered array
     * @return result array
     */
    int[] nullEven(int[] array);

    /**
     * Reset not even numbers
     *
     * @param array entered array
     * @return result array
     */
    int[] nullNotEven(int[] array);


    /**
     * Search first positive element
     *
     * @param array entered array
     * @return first positive element
     */
    int searchFirstPositiveNumber(int[] array);

    /**
     * Search last negative element
     *
     * @param array entered array
     * @return last negative element
     */
    int searchLastNegativeNumber(int[] array);

    /**
     * Search enter index in an array
     *
     * @param array entered array
     * @param number entered number
     * @return array with indexes
     */
    int[] searchIndexInputArray(int[] array, int number);

    /**
     * Checking ordered increasing array
     *
     * @param array entered array
     * @return true or false
     */
    boolean checkingOrderedIncreasingArray(int[] array);

    /**
     * Checking ordered decreasing array
     *
     * @param array entered array
     * @return true or false
     */
    boolean checkingOrderedDecreasingArray(int[] array);

    /**
     * Move array to right
     *
     * @param array entered array
     * @param k entered number
     * @return result array
     */
    int[] moveArrayRight(int[] array, int k);

    /**
     * Sum elements of array
     *
     * @param array entered array
     * @return summary of elements
     */
    int sumArray(int array[]);

    /**
     * Search amount of value which bigger than middle number into array
     *
     * @param array entered array
     * @return summary of elements which bigger than middle number
     */
    int searchValueMoreNumber(int [] array);

    /**
     * Display all elements that aren't duplicated
     *
     * @param array entered array
     * @return result array
     */
    int[] displayNotElement(int[] array);

    /**
     * Display elements that aren't into other array
     *
     * @param arrayFirst entered array
     * @param arraySecond entered array
     * @return result array
     */
    int[] displayElementAreNotSecondArray(int[] arrayFirst, int[] arraySecond);

    /**
     * Display elements that are into other array
     *
     * @param array entered array
     * @return result array
     */
    int[] displayElementDublicate(int[] array);

    /**
     * Count similarly value
     *
     * @param array entered array
     * @return amount of similarly value
     */
    int countSimilarlyValue(int[] array);

    /**
     * Create array from two sorted arrays
     *
     * @param firstArray entered sorted array
     * @param secondArray entered sorted array
     * @return exited sorted array
     */
    int[] thirdArrayFromTwoSortedArrays(int[] firstArray, int[] secondArray);

    /**
     * Change positive elements (first - last,...)
     *
     * @param array entered array
     * @return result array
     */
    int[] changePositiveFirstLastAndOther(int[] array);
}
