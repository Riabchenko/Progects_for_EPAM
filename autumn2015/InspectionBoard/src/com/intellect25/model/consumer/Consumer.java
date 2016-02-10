package com.intellect25.model.consumer;

import com.intellect25.entity.Institute;
import com.intellect25.model.Buffer;

/**
 * Abstract class of consumer
 *
 * @author Riabchenko Aliona
 */
public abstract class Consumer implements Runnable {

    /** Buffer */
    protected Buffer buffer;

    /**
     * Get object of Institute
     *
     * @return object of Institute
     */
    public abstract Institute get();
}
