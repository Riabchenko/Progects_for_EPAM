package com.intellect25.MyMap;
/**
 * 
 * @author Riabchenko Aliona
 * @version 1.0 Build 25.05.2015
 * This class implements interface MyMap
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyHashMap implements MyMap {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;// Define the default hash table size. Must be a power of 2
  private static final int MAXIMUM_CAPACITY = 1 << 30;// Define the maximum hash table size. 1 << 30 is same as 2^30
  private static final float DEFAULT_MAX_LOAD_FACTOR = 0.75f;// Define default load factor
  private static final int MULTIPLIER_FOR_CALCULATE_HASH = 31;//Define the multiplier for calculate hash


  private int size;// The number of entries in the map
  private int capacity;
  private double loadFactor;

  private ArrayList<LinkedList<SimpleEntry>> hashMap;

  /**
   * 
   * @author Riabchenko Aliona
   *
   */
  private class SimpleEntry implements MyMap.Entry{

      private Object key;
      private Object value;

      /**
       *It's the constructor for SimpleEntry
       * @param key Object of key
       * @param value Object of value
       */
      public SimpleEntry(Object key, Object value) {
          this.key = key;
          this.value = value;
      }

      /*
       * (non-Javadoc)
       * @see com.intellect25.MyMap.MyMap.Entry#getKey()
       */
      @Override
      public Object getKey() {
          return key;
      }

      /*
       * (non-Javadoc)
       * @see com.intellect25.MyMap.MyMap.Entry#getValue()
       */
      @Override
      public Object getValue() {
          return value;
      }

      /*
       * (non-Javadoc)
       * @see com.intellect25.MyMap.MyMap.Entry#setValue(java.lang.Object)
       */
      @Override
      public Object setValue(Object value) {
          Object tempValue = this.value;
          this.value = value;
          return tempValue;
      }

  }

  /**
   * Constructs an empty HashMap with the default initial capacity
   * and the default load factor (0.75).
   */
  public MyHashMap() {
      capacity = DEFAULT_INITIAL_CAPACITY;
      size = 0;
      loadFactor = DEFAULT_MAX_LOAD_FACTOR;
      hashMap = new ArrayList<>(capacity);
      for (int i = 0; i < capacity; i++) {
          hashMap.add(null);
          hashMap.set(i, new LinkedList<SimpleEntry>());
          hashMap.set(i, new LinkedList<SimpleEntry>());
      }

  }

  /**
   * Constructs an empty HashMap with the specified initial
   * capacity and the default load factor (0.75).
   * @param initialCapacity
   */
  public MyHashMap(int initialCapacity) {
      capacity = DEFAULT_INITIAL_CAPACITY;
      for (; capacity <= MAXIMUM_CAPACITY;) {
          if (initialCapacity < capacity) {
              break;
          }
          capacity = capacity << 1;
      }
      size = 0;
      loadFactor = DEFAULT_MAX_LOAD_FACTOR;

      hashMap = new ArrayList<>(capacity);
      for (int i = 0; i < capacity; i++) {
          hashMap.add(null);
          hashMap.set(i, new LinkedList<SimpleEntry>());
      }

  }

  /**
   * Constructs an empty HashMap with the specified initial
   * capacity and load factor.
   * @param initialCapacity
   * @param loadFactor
   */
  public MyHashMap(int initialCapacity, double loadFactor) {
      this(initialCapacity);
      this.loadFactor = loadFactor;
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#clear()
   */
  @Override
  public void clear() {
      for (int i = 0; i < capacity; i++) {
          hashMap.set(i, new LinkedList<SimpleEntry>());
      }
      size = 0;
  }

  /**
   *
   * @param key
   * @return
   */
  private int getHash(Object key) {
      return Math.abs((key.hashCode() * MULTIPLIER_FOR_CALCULATE_HASH) % capacity);
  }

  /**
   *This method gets index of HashMap
   * @param key
   * @param hash
   * @return
   */
  private int getKeyIndexOfHashMap(Object key, int hash) {
      List<SimpleEntry> someHash = hashMap.get(hash);
      int index = -1;
      if (!someHash.isEmpty()) {
          for (int i = 0; i < someHash.size(); i++) {
              if (key.equals(someHash.get(i).getKey())) {
                  index = i;
                  break;
              }
          }
      }
      return index;
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#containsKey(java.lang.Object)
   */
  @Override
  public boolean containsKey(Object key) {
      return getKeyIndexOfHashMap(key, getHash(key)) != -1;
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#containsValue(java.lang.Object)
   */
  @Override
  public boolean containsValue(Object value) {
      Iterator<? extends Entry> iterator = entryIterator();
      while (iterator.hasNext()) {
          if (value.equals(iterator.next().getValue())) {
              return true;
          }
      }
      return false;
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#get(java.lang.Object)
   */
  @Override
  public Object get(Object key) {
      int bucket = getHash(key);
      if (containsKey(key)) {
          SimpleEntry item = hashMap.get(bucket).get(getKeyIndexOfHashMap(key, bucket));
          return item.getValue();
      } else {
          throw new NoSuchElementException();
      }
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#isEmpty()
   */
  @Override
  public boolean isEmpty() {
      return size == 0;
  }

  /**
   *This method ensures the capacity of HashMap
   */
  private void ensureCapacity() {
      double currentFillRate = (double) size / capacity;
      if (currentFillRate > loadFactor & capacity < MAXIMUM_CAPACITY) {
          Iterator<? extends Entry> iterator = this.entryIterator();

          capacity = capacity << 1;

          hashMap = new ArrayList<>(capacity);
          for (int i = 0; i < capacity; i++) {
              hashMap.add(null);
              hashMap.set(i, new LinkedList<SimpleEntry>());
          }
          size = 0;
          Entry entry = null;
          while (iterator.hasNext()) {
              entry = iterator.next();
              this.put(entry.getKey(), entry.getValue());
          }
      }
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#put(java.lang.Object, java.lang.Object)
   */
  @Override
  public Object put(Object key, Object value) {
      ensureCapacity();
      int bucket = getHash(key);
      if (containsKey(key)) {
          SimpleEntry item = hashMap.get(bucket).get(getKeyIndexOfHashMap(key, bucket));
          return item.setValue(value);
      } else {
          hashMap.get(bucket).add(new SimpleEntry(key, value));
          size++;
          return null;
      }
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#remove(java.lang.Object)
   */
  @Override
  public Object remove(Object key) {
      int bucket = getHash(key);
      if (containsKey(key)) {
          SimpleEntry item = hashMap.get(bucket).remove(getKeyIndexOfHashMap(key, bucket));
          Object value = item.getValue();
          size--;
          return value;
      } else {
          throw new NoSuchElementException();
      }
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#size()
   */
  @Override
  public int size() {
      return size;
  }

  /*
   * (non-Javadoc)
   * @see com.intellect25.MyMap.MyMap#entryIterator()
   */
  @Override
  public Iterator<Entry> entryIterator() {
      return new entryIterator(this);
  }

  /**
   *This class implements Iterator<Entry>
   */
  private class entryIterator implements Iterator<Entry> {

      private MyHashMap map;
      private List<SimpleEntry> list = new LinkedList<>();
      private int index;

      /**
       * It's constructor for entryIterator
       * @param map
       */
      public entryIterator(MyHashMap map) {
          this.map = map;
          for (List tempList : hashMap) {
              list.addAll(tempList);
          }
          index = 0;
      }

      /*
       * (non-Javadoc)
       * @see java.util.Iterator#hasNext()
       */
      @Override
      public boolean hasNext() {
          return index < list.size();
      }

      /*
       * (non-Javadoc)
       * @see java.util.Iterator#next()
       */
      @Override
      public SimpleEntry next() {
          if (index >= list.size()) {
              throw new NoSuchElementException();
          }
          return list.get(index++);
      }

      /*
       * (non-Javadoc)
       * @see java.util.Iterator#remove()
       */
      @Override
      public void remove() {
          if (index >= list.size()) {
              throw new NoSuchElementException();
          }
          SimpleEntry entry = list.remove(index);
          map.remove(entry.getKey());
      }
  }
//--------------------------display----------------------------//	
  
  public void display() {
		for(LinkedList<SimpleEntry> e : hashMap){
			for(SimpleEntry se : e){
				System.out.print("HashCode = "+e.hashCode()+"  Key = "+e.peek().getKey()+"  ");
			}
			System.out.println();
		}
			
	}
	
}
