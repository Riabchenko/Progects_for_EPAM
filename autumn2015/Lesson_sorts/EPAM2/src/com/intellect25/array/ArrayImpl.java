package com.intellect25.array;

import java.util.Arrays;

/**
 * The ArrayImpl class
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class ArrayImpl implements Array{

    @Override
    public int[] searchMaxElementValueIndex(int array[]) {
        checkEmpty(array);
        checkNull(array);

        int[] result = new int[2];
        result [0] = array[0];

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                result [0] = i;
                result [1] = max;
            }
        }
        return result;
    }

    @Override
    public int[] searchMinElementValueIndex(int array[]){
        checkEmpty(array);
        checkNull(array);

        int[] result = new int[2];

        int min = array[0];
        for (int i = array.length - 1; i >= 0; i--){
            if(min > array[i]){
                min = array[i];
                result [0] = i;
                result [1] = min;
            }
        }
        return result;
    }

    @Override
    public double searchMiddleValue(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int sum = 0;
        double half = 0.0;

        for (int value : array){
            sum += value;
        }

        half = sum / array.length;
        return half;
    }

    @Override
    public int countElementIsZero(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int count = 0;
        int zero = 0;

        for (int value : array){
            if(value == zero){
                count++;
            }
        }
        return count;
    }

    @Override
    public int countElementIsMoreZero(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int count = 0;
        int example = 0;

        for(int value : array){
            if(value > example ){
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] multiplicationElementNumber(int[] array, int number) {
        checkEmpty(array);
        checkNull(array);

        for (int i = 0; i < array.length; i++){
            array[i] = array[i] * number;
        }
        return array;
    }

    @Override
    public int[] sumElementAndIndex(int[] array) {
        checkEmpty(array);
        checkNull(array);

        for (int i = 0; i < array.length; i++){
            array[i] = i + array[i];
        }
        return array;
    }

    @Override
    public int[] nullEven(int[] array) {
        checkEmpty(array);
        checkNull(array);

        for (int value = 0; value < array.length; value++) {
            if (array[value] % 2 == 0){
                array[value] = 0;
            }
        }
        return array;
    }

    @Override
    public int[] nullNotEven(int[] array) {
        checkEmpty(array);
        checkNull(array);

        for (int value = 0; value < array.length; value++) {
            if (array[value] % 2 != 0){
                array[value] = 0;
            }
        }
        return array;
    }

    @Override
    public int searchFirstPositiveNumber(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int firstEvenNumber = 0;
        for (int value = 0; value < array.length; value++) {
            if (array[value] > 0){
                firstEvenNumber = array[value];
                break;
            }
        }
        return firstEvenNumber;
    }

    @Override
    public int searchLastNegativeNumber(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int number = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if(array[i] < 0){
                number = array[i];
                break;
            }
        }
        return number;
    }

    @Override
    public int[] searchIndexInputArray(int[] array, int number) {
        checkEmpty(array);
        checkNull(array);

        int count = 0;
        int[] newArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                newArray[count] = i;
                count++;
            }
        }
        return newArray;
    }

    @Override
    public boolean checkingOrderedIncreasingArray(int[] array) {
        checkEmpty(array);
        checkNull(array);

        boolean sorted = true;
        for(int i = 0; i >= array.length; i++){
            if(array[i] > array[i + 1]){ //if next bigger precedent - not sorted
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    @Override
    public boolean checkingOrderedDecreasingArray(int[] array) {
        checkEmpty(array);
        checkNull(array);

        boolean sorted = true;
        for(int i = 0; i >= array.length; i++){
            if(array[i] < array[i + 1]){ //if next less precedent - not sorted
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    @Override
    public int[] moveArrayRight(int[] array, int k) {
        checkEmpty(array);
        checkNull(array);

        int[] shiftedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            shiftedArray[(i + k) % array.length] = array[i];
        }
        return shiftedArray;
    }

    @Override
    public int sumArray(int array[]) {
        checkEmpty(array);
        checkNull(array);

        int summary = 0;
        for (int value : array) {
            summary += value;
        }
        return summary;
    }

    @Override
    public int searchValueMoreNumber(int [] array) {
        checkEmpty(array);
        checkNull(array);

        int sum = 0;
        for(int value : array){
            sum += value;
        }

        double percent = sum / array.length;

        int count = 0;
        for(int value : array){
            if(value > percent){
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] displayElementAreNotSecondArray(int[] arrayFirst, int[] arraySecond) {
        checkEmpty(arrayFirst);
        checkNull(arrayFirst);
        checkEmpty(arraySecond);
        checkNull(arraySecond);

        int x = 0;
        int [] differentElement = new int [arrayFirst.length+arraySecond.length];

        for (int i = 0; i < arrayFirst.length; i++) {
            int key = arrayFirst[i];
            boolean is = false;

            for (int h = 0; h < arraySecond.length; h++) {
                int keySec = arraySecond[h];

                if (keySec == key) {
                    is = true;
                }
            }
            if (is == false){
                differentElement[x++] = key;
            }
        }
        return  differentElement;
    }

    @Override
    public int[] displayElementDublicate(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int x = 0;
        int [] differentElement = new int [array.length];
        for (int i = 0; i < array.length; i++){
            int key = array[i];

            for(int g = i + 1; g < array.length; g++){
                if(array[g] == key){
                    differentElement[x++] = array[i];
                }
            }
        }
        return  differentElement;
    }

    @Override
    public int[] displayNotElement(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int x = 0;
        int [] notElement = new int [array.length];

        for (int i = 0; i < array.length; i++){
            int key = array[i];
            boolean is = false;

            for(int k = i + 1; k < array.length; k++){
                if(array[k] == key){
                    is = true;
                }
            }

            if(Arrays.binarySearch(array,key) > 0){
                is = true;
            }

            if (is == false){
                notElement[x++] = key;
            }
        }
        return notElement;
    }

    @Override
    public int countNeedElement(int[] array, int number) {
        checkEmpty(array);
        checkNull(array);

        int count = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == number){
                count++;
            }
        }
        return count;
    }

    @Override
    public int countSimilarlyValue(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == array[0]){
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] thirdArrayFromTwoSortedArrays(int[] firstArray, int[] secondArray) {
        checkEmpty(firstArray);
        checkEmpty(secondArray);
        checkNull(firstArray);
        checkNull(secondArray);

        int[] thirsArray = new int[firstArray.length+secondArray.length];
        int firstLow = 0;
        int firstHigth = firstArray.length-1;
        int secondLow = 0;
        int secondHigth = secondArray.length-1;

        for(int i = 0; i < thirsArray.length; i++) {
            if (firstLow > firstHigth) thirsArray[i] = secondArray[secondLow++];
            else if (secondLow > secondHigth) thirsArray[i] = firstArray[firstLow++];
            else if (less(firstArray[firstLow], secondArray[secondLow])) {
                thirsArray[i] = firstArray[firstLow++];
            } else {
                thirsArray[i] = secondArray[secondLow++];
            }
        }
        return thirsArray;
    }

    /* Helper for thirdArrayFromTwoSortedArrays*/
    private boolean less(int first, int next){
        return first-next < 0;
    }

    @Override
    public int[] changePositiveFirstLastAndOther(int[] array) {
        checkEmpty(array);
        checkNull(array);

        int middle = (array.length-1)/2;

        int i = 0;
        int j = array.length-1;
        for(int k = 0; k < middle; k++) {
            if (array[i] > 0 && array[j] > 0) {
                change(array,i,j);
            }
            i++;
            j--;
        }
        return array;
    }

    /* Helper for changePositiveFirstLastAndOther*/
    private void change(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array [second];
        array [second] = temp;
    }

    /* Helper for methods*/
    private void checkNull(int [] array){
        if (array == null) throw new NullPointerException("Array is null");
    }

    /* Helper for methods*/
    private void checkEmpty(int [] array){
        if (array.length < 1) throw new IllegalArgumentException("Array is empty");
    }
}
