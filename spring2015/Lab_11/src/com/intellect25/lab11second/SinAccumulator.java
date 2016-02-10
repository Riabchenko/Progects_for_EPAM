package com.intellect25.lab11second;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.06.2015
*
* This class contains method for runs  multi-threaded  
* within sum up all the sins
*/
public class SinAccumulator {
    
    public static volatile Double result = 0.0;

    /**
     * Sum up all the sins 
     * @param N indicator of the range
     * @param threads number of desirable threads
     * @return sum of all the sins within given range
     */
    public static double countSin(int N, int threads) {       
        result = 0.0;
        int begin = - N;
        int numForThread = N*2+1 / threads;
        
        for(int thread = 0; thread < threads; thread++) {
            int maxForThread = begin + numForThread;
            if(thread == threads - 1 || maxForThread >= N) maxForThread = N;
            Thread t = new Thread(new SinFinder(begin, maxForThread));
            t.start();
            
            if(thread == 0) {
                try {
                    t.join();
                }
                catch(InterruptedException e) {
                    e.getMessage();
                }
            }          
            begin = maxForThread + 1;
        }
        return result;
    }
}
