package com.intellect25.controller;

import com.intellect25.entity.Institute;
import com.intellect25.model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Manage creation of buffer,dispatcher of consumer,dispatcher of producer
 *
 * @author Riabchenko Aliona
 */
public class Dispatcher implements Runnable{

    /** String BIOLOGY is name of Institute*/
    private static final String BIOLOGY = "BIOLOGY";

    /** String MATHEMATICS is name of Institute*/
    private static final String MATHEMATICS = "MATHEMATICS";

    /** String ANYTHING is name of Institute*/
    private static final String ANYTHING = "ANYTHING";

    /** Store result */
    private Map<String,Institute> result;

    @Override
    public void run() {
        try {
            start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create buffer,dispatchers of consumers and producers
     * Create thread to consumers and producers
     * Start threaders and join to them
     * Get result
     *
     * @throws InterruptedException
     */
    private void start() throws InterruptedException {
        Factory factory = Factory.getInstance();

        Buffer buffer = (Buffer) factory.create(Type.BUFFER, null);
        DispatcherOfConsumers consumers = (DispatcherOfConsumers) factory.create(Type.CONSUMER, buffer);
        DispatcherOfProducers producers = (DispatcherOfProducers) factory.create(Type.PRODUCER, buffer);

        Thread threadConsumers = new Thread(consumers);
        Thread threadProducers = new Thread(producers);

        threadConsumers.start();
        threadProducers.start();

        threadConsumers.join();
        threadProducers.join();

        /* Get result */
        result = new HashMap<>();
        result.put(MATHEMATICS, consumers.getConsumerMathematicsObject().get());
        result.put(BIOLOGY, consumers.getConsumerBiologyObject().get());
        result.put(ANYTHING, consumers.getConsumerAnythingObject().get());
    }

    /**
     * Get result
     *
     * @return map of result
     */
    public Map<String,Institute> getResult() {
        return result;
    }
}
