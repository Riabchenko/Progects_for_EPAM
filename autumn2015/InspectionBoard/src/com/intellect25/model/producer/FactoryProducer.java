package com.intellect25.model.producer;


import com.intellect25.model.Buffer;

/**
 * Factory for Producers
 *
 * @author Riabchenko Aliona
 */
public class FactoryProducer {
    private static FactoryProducer factoryProducer;

    private FactoryProducer() {
    }

    public static FactoryProducer getInstance(){
        if (factoryProducer == null)
            factoryProducer = new FactoryProducer();
        return factoryProducer;
    }

    public Object create(TypeProducer typeProducer,Buffer buffer){
        switch (typeProducer){
            case PRODUCER_THREAD:
                return new Producer(buffer);

            default:
                throw new NullPointerException("");
        }
    }
}
