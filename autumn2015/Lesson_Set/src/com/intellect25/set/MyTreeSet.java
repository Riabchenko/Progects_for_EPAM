package com.intellect25.set;

import java.util.Iterator;

/**
 * Created by apple on 12/2/15.
 */

public interface MyTreeSet<T extends Comparable<T>> {

    /**
     * add item to set
     * @param item  element
     */
    public void add (T item);

    /**
     * remove item from set
     * @param item   element
     * @return       true when remove good
     */
    public boolean remove (T item);

    /**
     * find item in set
     * @param item   element
     * @return       true when item present in set
     */
    public boolean contains (T item);

    /**
     * for going in set
     * @return      iterator
     */
    public Iterator iterator();
}
