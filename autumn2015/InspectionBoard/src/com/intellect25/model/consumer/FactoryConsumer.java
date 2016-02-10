package com.intellect25.model.consumer;

import com.intellect25.model.Buffer;

/**
 * Factory for Consumer
 *
 * @author Riabchenko Aliona
 */
public class FactoryConsumer {
    private static FactoryConsumer factoryConsumer;

    private FactoryConsumer() {
    }

    public static FactoryConsumer getFactoryConsumer(){
        if (factoryConsumer == null)
            factoryConsumer = new FactoryConsumer();
        return factoryConsumer;
    }

    public Object create(TypeConsumer typeConsumer,Buffer buffer){
        switch (typeConsumer){
            case BIOLOGY_THREAD:
                return new ConsumerBiology(buffer);
            case MATHEMATICS_THREAD:
                return new ConsumerMathematics(buffer);
            case ANYTHING_THREAD:
                return new ConsumerAnything(buffer);

            default:
                throw new NullPointerException("");
        }
    }
}
