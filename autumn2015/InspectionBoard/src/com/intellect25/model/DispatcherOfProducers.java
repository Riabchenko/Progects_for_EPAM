package com.intellect25.model;

import com.intellect25.entity.FactoryEntity;
import com.intellect25.entity.Form;
import com.intellect25.entity.TypeEntity;
import com.intellect25.model.producer.FactoryProducer;
import com.intellect25.model.producer.Producer;
import com.intellect25.model.producer.TypeProducer;


/**
 * Dispatcher of Producers
 *
 * @author Riabchenko Aliona
 */
public class DispatcherOfProducers implements Runnable{

    /** Buffer */
    private Buffer buffer;

    /** Thread for producers that put form to buffer*/
    private Thread threadProducer;

    /** Objects of Producer*/
    private Producer producer;

    /**
     * Constructor
     *
     * @param buffer buffer
     */
    public DispatcherOfProducers(Buffer buffer) {
        this.buffer = buffer;

        FactoryProducer factoryProducer = FactoryProducer.getInstance();

        producer = (Producer) factoryProducer.create(TypeProducer.PRODUCER_THREAD, buffer);
        threadProducer = createThread(producer);
    }

    private Thread createThread(Producer producer){
        return new Thread(producer);
    }

    @Override
    public void run() {
        synchronized (this){
            while (true) {
                try {
                   if(!workAllProducers()) break;
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    /**
     * Work all producers
     *
     * @return false or true
     * @throws InterruptedException
     */
    private boolean workAllProducers() throws InterruptedException {
        threadProducer.start();
        threadProducer.join();

        buffer.put((Form) FactoryEntity.getInstance().create(TypeEntity.CONCLUSION));

        if (threadProducer.isInterrupted()) return true;
        return false;
    }
}
