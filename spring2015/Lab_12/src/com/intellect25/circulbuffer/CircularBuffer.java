package com.intellect25.circulbuffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
*
* @author Aliona Riabchenko
* @version 1.0 Build 20.06.2015
*
*
*/
public class CircularBuffer {
       
    private final int capacity;
    private Object[] contents;
    private int addIndex = 0;
    private int takeIndex = 0;
    private int length = 0; //Length of buffer
    
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        contents = new Object[capacity];
    }
    
    public CircularBuffer() {
        this(10);
    }
    
    /**
     * Add new element to the buffer
     * Method is synchronized
     * @param element int
     * @return 
     */
    public synchronized boolean add(Object element) {
    	if (isFull()) return false;
    	else{
    		contents[this.addIndex % this.capacity] = element;
        if(this.addIndex == this.takeIndex) this.takeIndex++;
        this.addIndex++;
        this.length++;
        if(this.length > this.capacity) this.length = this.capacity;
        return true;
    	}
    }
    
    /**
     * Take an element from Circular Buffer without deleting
     * @return next element in the queue
     */
    public Object peek() {
        if(this.length > 0) {
            return this.contents[takeIndex % this.capacity];
        }else{
        String m = "Circular Buffer is empty";
        BlockCircularBuffer.setSb(m);
        return null;}
    }
    
    /**
     * Take and delete (move deletion cursor) element from the buffer
     * @return next integer in the queue
     */
    public synchronized Object poll() {
        if(this.length > 0) {
            Object result = this.contents[takeIndex % this.capacity];
            this.takeIndex++;
            this.length--;
            if(this.length < 0) this.length = 0;
            return result;
        }else{
        String m1 = "Circular Buffer is empty";
        BlockCircularBuffer.setSb(m1);
        return null;}
    }
    
    /**
     * Size of the Circular Buffer
     * @return number of elements in the buffer
     */
    public int size() {
        return this.length;
    }
    
    /**
     * Check if the buffer is full
     * @return true, if buffer is full, false otherwise
     */
    public boolean isFull() {
        return this.length == this.capacity;
    }
    
    /**
     * String representation of the buffer
     * @return String representation of the current circular buffer
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < this.size(); i++) {
            result.append(this.contents[(takeIndex+i) % this.capacity]).append(" ");
        }
        return result.toString();
    }
    

}
