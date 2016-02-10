package com.intellect25.realisation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Riabchenko Aliona
 */
public interface ListInterface<T> {
    /**
     * Adds the specified element to the end of this list.
     *
     * @param value value to be added to the end of this list
     * @return <code>true</code> if there are no exception
     */
    boolean add(T value);

    /**
     * Replaces value at specified position int this list with specified
     * element.
     *
     * @param index index of the element to replace
     * @param value value to be stored at the specified position
     * @return the element previously stored at the specified position
     */
    T set(int index, T value);

    /**
     * Returns element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException If given index is out of range of this
     * list
     */
    @SuppressWarnings("unchecked")
    T get(int index);

    /**
     * Returns the index of the first occurence of the specified element in this
     * list, or -1 if this list does not contain the element.
     *
     * @param obj value to find it's index of first occurence in this list
     * @return first occurence of the specified element in this list; -1 if this
     * list does not contain the element
     */
    @SuppressWarnings("unchecked")
    int indexOf(Object obj);

    /**
     * Removes specified value in this list.
     *
     * @param value value to remove from this list
     * @return <code>true</code> if element was found in this list and was
     * removed. <code>false</code> if there is no occurence if specified element
     * in this list
     */
    @SuppressWarnings("unchecked")
    boolean remove(Object value);

    /**
     * Removes value with specified index from this list. If index is out of
     * arraylist range - throws {@link IllegalArgumentException}
     *
     * @param index index of element in this list to remove
     * @return value that was removed from the list
     * @throws IndexOutOfBoundsException if index is out of range
     */
    @SuppressWarnings("unchecked")
    T remove(int index);

    /**
     * Returns number of value in this list
     *
     * @return number of value in this list
     */
    int size();

    /**
     * Checks if this list contains any elements.
     *
     * @return <code>true</code> if list is empty; <code>false</code> if list
     * isn't empty
     */
    boolean isEmpty();

    Iterator<T> iterator();

    boolean contains(Object o);

    void clear();

    void add(int index, T element);

    Object[] toArray();

    <T> T[] toArray(T[] a);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends T> c);

    boolean addAll(int index, Collection<? extends T> c);

    boolean removeAll(Collection<?> c);

    boolean retainAll(Collection<?> c);

    int lastIndexOf(Object o);

    ListIterator<T> listIterator();

    ListIterator<T> listIterator(int index);

    List<T> subList(int fromIndex, int toIndex);
}
