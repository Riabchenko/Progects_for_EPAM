package com.intellect25.lab11first;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.06.2015
*
*This class contains method for runs  multi-threaded 
*
*/
public class PrimeAccumulator {
    
    /**
     * This method runs  multi-threaded 
     * @param threads number of desirable threads
     * @param maxPrimeNumber max number to check for being main
     */
    public void findPrimesNumber(int threads, int maxPrimeNumber) {
        int maxForThread = maxPrimeNumber / threads;
        int minPrime = 2;
        for(int thread = 0; thread < threads; thread++) {
            Thread t = new Thread(new SearchPrimeNumbers(minPrime, maxForThread));
            t.start();
            minPrime = maxForThread + 1;
            maxForThread += maxPrimeNumber / threads;
        }
    }
    
}
