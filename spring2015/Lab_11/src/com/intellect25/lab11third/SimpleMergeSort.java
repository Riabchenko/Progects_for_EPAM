package com.intellect25.lab11third;

import java.util.List;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.06.2015
*
* This class straight implementation of merge sort for testing
*
*/
public class SimpleMergeSort {
    
    public static List<Integer> mergeSort(List<Integer> array) {
        if(array.size() > 1) {
            List<Integer> left = mergeSort(array.subList(0, array.size()/2));
            List<Integer> right = mergeSort(array.subList(array.size()/2, array.size()));
            return ThreadedMergeSort.merge(left, right);
        }
        return array;
    }
}
