
package com.intellect25.realisation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;

/**
 * This class represents resizable-array list. Implements methods of
 * <code>Iterable</code> interface.
 *
 * @author Riabchenko Aliona
 */
public class ArrayList<T> implements Iterable<T>,ListInterface<T> {

    /**
     * Default capacity of arraylist
     */
    private final int DEFAULT_CAPACITY = 10;
    /**
     * Array that represents empty array with no elements and zero size
     */
    private final Object[] EMPTY_VALUES = new Object[]{};
    /**
     * Array where all values are stored
     */
    private Object[] values;
    /**
     * The number of elements that arraylist contains
     */
    private int size;

    /**
     * Constructs an empty ArrayList with specified initial capacity
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity is
     * negative
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            values = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            values = EMPTY_VALUES;
        } else {
            throw new IllegalArgumentException("Got illegal argument: " + initialCapacity + ".");
        }

    }

    /**
     * Constructs an empty list with zero initial capacity
     */
    public ArrayList() {
        values = EMPTY_VALUES;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param value value to be added to the end of this list
     * @return <code>true</code> if there are no exception
     */
    public boolean add(T value) {
        ensureCapacity(size + 1);
        values[size++] = value;
        return true;
    }

    /**
     * Replaces value at specified position int this list with specified
     * element.
     *
     * @param index index of the element to replace
     * @param value value to be stored at the specified position
     * @return the element previously stored at the specified position
     */
    public T set(int index, T value) {
        rangeCheck(index);

        @SuppressWarnings("unchecked")
        T returnedValue = (T) values[index];
        values[index] = value;
        return returnedValue;
    }

    /**
     * Returns element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException If given index is out of range of this
     * list
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheck(index);

        return (T) values[index];
    }

    /**
     * Returns the index of the first occurence of the specified element in this
     * list, or -1 if this list does not contain the element.
     *
     * @param obj value to find it's index of first occurence in this list
     * @return first occurence of the specified element in this list; -1 if this
     * list does not contain the element
     */
    @SuppressWarnings("unchecked")
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        T value = (T) obj;
        for (int i = 0; i < size; i++) {
            if (values[i].hashCode() == value.hashCode()
                    && Objects.equals(values[i], value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes specified value in this list.
     *
     * @param value value to remove from this list
     * @return <code>true</code> if element was found in this list and was
     * removed. <code>false</code> if there is no occurence if specified element
     * in this list
     */
    @SuppressWarnings("unchecked")
    public boolean remove(Object value) {

        int indexOfValue = indexOf(value);
        if (indexOfValue == -1) {
            return false;
        }

        removeByProvenIndex(indexOfValue);
        return true;
    }

    /**
     * Removes value with specified index from this list. If index is out of
     * arraylist range - throws {@link IllegalArgumentException}
     *
     * @param index index of element in this list to remove
     * @return value that was removed from the list
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        rangeCheck(index);
        return removeByProvenIndex(index);
    }

    /**
     * Returns number of value in this list
     *
     * @return number of value in this list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if this list contains any elements.
     *
     * @return <code>true</code> if list is empty; <code>false</code> if list
     * isn't empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if given index is in range of stored elements. Throws
     * {@link IndexOutOfBoundsException} otherwise
     *
     * @param index index to check for being in range of stored elements
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Got index out of range: " + index);
        }
    }

    /**
     * Ensures that given capacity is enough for stored elements. If it is not -
     * arraylist grows.
     *
     * @param capacity capacity to check for being enough to store elements
     */
    private void ensureCapacity(int capacity) {
        if (capacity - values.length > 0) {
            grow(capacity);
        }
    }

    /**
     * Increases number of elements in arraylist by formula: 3*size/2 + 1
     *
     * @param capacity base of new size of arraylist
     */
    private void grow(int capacity) {
        int oldCapacity = capacity;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //int newCapacity = oldCapacity * 3 / 2 + 1;
        values = Arrays.copyOf(values, newCapacity);
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        /**
         * Element that iterator currently indicates
         */
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) values[cursor++];
        }

        public void remove() {
            if (cursor <= 0) {
                throw new IllegalStateException("Iterator has not returned any "
                        + "element, so it can't remove anything!");
            }
            System.arraycopy(values, cursor, values, cursor - 1, size - cursor);
            values[size - 1] = null;
            size--;
            cursor--;
        }
    }

    /**
     * Removes element by specified index without checking for index being in
     * range
     *
     * @param index index ot remove element by
     * @return removed value
     */
    @SuppressWarnings("unchecked")
    private T removeByProvenIndex(int index) {
        T removedValue = (T) values[index];
        if (index + 1 != size) {
            int numMoved = size - index - 1;
            System.arraycopy(values, index + 1, values, index, numMoved);
        }
        values[size - 1] = null;
        size--;
        return removedValue;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public void clear() {
        values = EMPTY_VALUES;
        size = 0;
    }

    public void add(int index, T element) {
        ensureCapacity(size + 1);
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = element;
        size++;
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public java.util.List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
