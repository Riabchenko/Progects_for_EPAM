package com.intellect25.model;

/**
 * Factory for PRODUCER,CONSUMER,BUFFER
 *
 * @author Riabchenko Aliona
 */
public class Factory {
    private static Factory factory;

    private Factory() {
    }

    public static Factory getInstance(){
        if (factory == null)
            factory = new Factory();
        return factory;
    }

    public Object create(Type type,Buffer buffer){
        switch (type){
            case PRODUCER:
                return new DispatcherOfProducers(buffer);
            case CONSUMER:
                return new DispatcherOfConsumers(buffer);
            case BUFFER:
                return new Buffer();

            default:
                throw new NullPointerException("");
        }
    }
}
