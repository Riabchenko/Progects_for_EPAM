package com.intellect25.lab11first;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 14.06.2015
*
* This class implements Runnable and search a prime numbers.
*
*/
public class SearchPrimeNumbers implements Runnable {
    
    private int begin;
    private final int end;
    
    /**
     * It's constructor for SearchPrimeNumbers
     * @param begin it's the first number 
     * @param end it's the last number 
     */
    public SearchPrimeNumbers(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while(begin <= end) {
            if(isPrime(begin)) {
            	String data = begin + " ";
            	System.out.println(data);
            }
            begin++;
        }
    }
    
    /**
     * Check if given number is prime
     * @param number number to check
     * @return true or false 
     */
    public static boolean isPrime(int number) {
        if (number <= 1)  return false;
        if (number == 2)  return true;
        for (int i = 2; i <= Math.sqrt(number) + 1; i++) {
            if (number % i == 0)  return false;
        }
        return true;
    } 
   
}
