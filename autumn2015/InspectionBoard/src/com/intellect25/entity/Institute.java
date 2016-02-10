package com.intellect25.entity;

import java.util.Queue;

/**
 * Created by apple on 12/12/15.
 */
public abstract class Institute {

    /**
     * Poll form
     *
     * @return form
     */
    public abstract Form poll();

    /**
     *  Offer form
     *
     * @param form form
     */
    public abstract void offer(Form form);

    /**
     * Get size of list of form
     *
     * @return size
     */
    public abstract int size();

    /**
     * Get list of form
     *
     * @return Queue
     */
    public abstract Queue<Form> getList();
}
