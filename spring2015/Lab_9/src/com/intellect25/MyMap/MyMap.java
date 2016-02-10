package com.intellect25.MyMap;

import java.util.Iterator;

public interface MyMap {
	/**
	 * removes all of the mappings from this map
	 */
  public void clear();
  /**
   * returns true if this map contains a mapping for the specified key
   * @param key
   * @return
   */
  public boolean containsKey(Object key);
  /**
   * returns true if this map maps one or more keys to the specified value
   * @param value
   * @return
   */
  public boolean containsValue(Object value); 
  /**
   * returns the value to which the specified key is mapped, or null if this map contains nomapping for the key
   * @param key
   * @return
   */
  public Object get(Object key); 
  /**
   * returns true if this map contains no key-value mappings
   * @return
   */
  public boolean isEmpty();
  /**
   * associates the specified value with the specified key in this map
   * @param key
   * @param value
   * @return
   */
  public Object put(Object key, Object value);  
  /**
   * removes the mapping for the specified key from this map if present
   * @param key
   * @return
   */
  public Object remove(Object key); 
  /**
   * returns the number of key-value mappings in this map
   * @return
   */
  public int size();  
  /**
   * returns an iterator over the elements (MyMap.Entry) in proper sequence
   * @return
   */
  public Iterator entryIterator();

  interface Entry {
  	/**
  	 * сompares the specified object with this entry for equality
  	 * @param o
  	 * @return
  	 */
    public  boolean equals(Object o);
    /**
     * returns the key corresponding to this entry
     * @return
     */
    public Object getKey(); 
    /**
     * returns the value corresponding to this entry
     * @return
     */
    public Object getValue();
    /**
     * returns the hash code value for this map entry
     * @return
     */
    public int hashCode(); 
    /**
     * replaces the value corresponding to this entry with the specified value
     * @param value
     * @return
     */
    public  Object setValue(Object value); 
  }
}
