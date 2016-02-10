package com.intellect25.model;

import com.intellect25.model.consumer.*;

/**
 * Dispatcher of Consumers
 *
 * @author Riabchenko Aliona
 */
public class DispatcherOfConsumers implements Runnable {

    /** Buffer */
    private Buffer buffer;

    /** Thread for consumers that take form from buffer*/
    private Thread threadMathematics;
    private Thread threadBiology;
    private Thread threadAnything;

    /** Objects of consumers*/
    private ConsumerMathematics consumerMathematicsObject;
    private ConsumerBiology consumerBiologyObject;
    private ConsumerAnything consumerAnythingObject;

    /**
     * Constructor
     *
     * @param buffer buffer
     */
    public DispatcherOfConsumers(Buffer buffer) {
        this.buffer = buffer;
        init();
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!buffer.isStopConsumer()) {
                try {
                    manage();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    /**
     * Get Object of consumer of Mathematics
     *
     * @return ConsumerMathematics
     */
    public ConsumerMathematics getConsumerMathematicsObject() {
        return consumerMathematicsObject;
    }

    /**
     * Get Object of consumer of Biology
     *
     * @return ConsumerBiology
     */
    public ConsumerBiology getConsumerBiologyObject() {
        return consumerBiologyObject;
    }

    /**
     * Get Object of consumer of Anything
     *
     * @return ConsumerAnything
     */
    public ConsumerAnything getConsumerAnythingObject() {
        return consumerAnythingObject;
    }

    /**
     * Manage of consumers
     *
     * @throws InterruptedException
     */
    private void manage() throws InterruptedException {
        workAnything();
        workMathematics();
        workBiology();
    }

    /**
     * Work Anything
     *
     * @throws InterruptedException
     */
    private void workAnything() throws InterruptedException {
        threadAnything.run();
        threadAnything.join();
        threadAnything.interrupt();
    }

    /**
     * Work Mathematics
     *
     * @throws InterruptedException
     */
    private void workMathematics() throws InterruptedException{
        threadMathematics.run();
        threadMathematics.join();
        consumerBiologyObject.put(consumerMathematicsObject.getFormOfBiology());
    }

    /**
     * Work Biology
     *
     * @throws InterruptedException
     */
    private void workBiology() throws InterruptedException{
        threadBiology.run();
        threadBiology.join();
        consumerMathematicsObject.put(consumerBiologyObject.getFormOfMathematics());
    }

    /**
     * Initialization objects and threads
     */
    private void init(){
        FactoryConsumer factoryConsumer = FactoryConsumer.getFactoryConsumer();

        consumerMathematicsObject = (ConsumerMathematics) factoryConsumer.create(TypeConsumer.MATHEMATICS_THREAD, buffer);
        threadMathematics = createThread(consumerMathematicsObject);

        consumerBiologyObject = (ConsumerBiology) factoryConsumer.create(TypeConsumer.BIOLOGY_THREAD,buffer);
        threadBiology = createThread(consumerBiologyObject);

        consumerAnythingObject = (ConsumerAnything) factoryConsumer.create(TypeConsumer.ANYTHING_THREAD,buffer);
        threadAnything = createThread(consumerAnythingObject);
    }

    /**
     * Create threads
     *
     * @param consumer consumer
     * @return thread
     */
    private Thread createThread(Consumer consumer){
        return new Thread(consumer);
    }
}
