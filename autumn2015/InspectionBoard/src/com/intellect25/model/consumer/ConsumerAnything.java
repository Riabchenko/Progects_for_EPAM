package com.intellect25.model.consumer;

import com.intellect25.entity.*;
import com.intellect25.model.Buffer;

import java.util.Random;

/**
 * One of consumers witch takes forms and puts them to
 * object of Anything (Institute)
 *
 * @author Riabchenko Aliona
 */
public class ConsumerAnything extends Consumer {

    /** Received Forms puts in this object (Institute) */
    private Anything anything;

    /**  Generate count of forms which need to take from buffer*/
    private Random random;

    {
        /** Object of institute */
        anything = (Anything) FactoryEntity.getInstance().create(TypeEntity.ANYTHING);
        random = new Random();
    }

    /**
     * Constructor
     *
     * @param buffer buffer
     */
    public ConsumerAnything(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (this) {
            int i = random.nextInt(5);
            while (i > 0 && !buffer.isStopConsumer()) {
                if (!put(buffer.get())) return;
                i--;
            }
        }

    }

    @Override
    public synchronized Anything get() {
        return anything;
    }

    /**
     * Puts form to Object of Institute
     *
     * @param form input form
     * @return false or true
     */
    public synchronized boolean put(Form form){
        if(form!= null){
            anything.offer(form);
            return true;
        } else return false;
    }

}
