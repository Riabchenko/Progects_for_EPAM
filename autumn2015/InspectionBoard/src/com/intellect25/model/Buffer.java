package com.intellect25.model;

import com.intellect25.entity.Conclusion;
import com.intellect25.entity.Form;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Buffer
 *
 * @author Riabchenko Aliona
 */
public class Buffer {

    /** Max size of buffer */
    private static final int MAX_SIZE = 50;

    /** Middle size of buffer*/
    private static final int MIDDLE_SIZE = 25;

    /** switch for producer */
    private boolean stopProducer;

    /** switch for consumer */
    private boolean stopConsumer;

    /** switch for available  */
    private boolean available;

    /** Store queue */
    private Queue<Form> queue = new LinkedList<>();

    /**
     * Get form from buffer
     *
     * @return form
     */
    public synchronized Form get() {

        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }

        Form temp = queue.poll();

        /* if one element left and enable stopProducer */
        if (queue.size() == 1 && isStopProducer()) setStopConsumer(true);

        /* if true, that it not repeat, anything can't get */
        if (queue.size() <= MIDDLE_SIZE && !isStopProducer()) available = false;

        notifyAll();
        return temp;
    }

    /**
     * Put form to buffer
     *
     * @param form form
     */
    public synchronized void put(Form form) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }

        /* Switch on a stopProducer */
        if (form instanceof Conclusion)  setStopProducer(true);

        /* Put form to buffer */
        if (queue.size() <= MAX_SIZE) queue.offer(form);

        /* queue is full or enable stopProducer => wait */
        if ( queue.size() == MAX_SIZE || isStopProducer())  available = true;

        notifyAll();
    }

    /**
     * Check Consumer's switch
     *
     * @return true or false
     */
    public synchronized boolean isStopConsumer() {
        return stopConsumer;
    }

    /**
     * Check Producer's switch
     *
     * @return  true or false
     */
    public synchronized boolean isStopProducer() {
        return stopProducer;
    }

    /**
     * Change Producer's switch
     *
     * @param stopProducer true or false
     */
    private void setStopProducer(boolean stopProducer) {
        this.stopProducer = stopProducer;
    }

    /**
     * Change Consumer's switch
     *
     * @param stopConsumer true or false
     */
    private void setStopConsumer(boolean stopConsumer) {
        this.stopConsumer = stopConsumer;
    }
}








