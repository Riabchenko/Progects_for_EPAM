package com.intellect25.lab11third;

import java.util.List;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.06.2015
*
*This class implements Runnable and it doing merge sort
*
*/
public class MergeThread implements Runnable {
    
    public List<Integer> array;
    /**
     * It's constructor
     * @param array input list of numbers
     */
    public MergeThread(List<Integer> array) {
        this.array = array;
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        ThreadedMergeSort.mergeSort(this.array);
    }
    
}
