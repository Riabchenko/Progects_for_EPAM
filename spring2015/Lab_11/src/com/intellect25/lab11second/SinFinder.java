package com.intellect25.lab11second;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.06.2015
*
* This class implements Runnable and sum up all result
*
*/
public class SinFinder implements Runnable {

    private final int begin;
    private final int end;
    /**
     * It's constructor for SinFinder
     * @param begin it's the first number 
     * @param end it's the last number 
     */
    public SinFinder(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for(int num = this.begin; num <= this.end; num++) {
            SinAccumulator.result += (float) Math.sin(num);
            System.out.println(SinAccumulator.result);
        }
    }
    
}
