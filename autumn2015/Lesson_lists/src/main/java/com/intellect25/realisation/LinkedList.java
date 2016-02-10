
package com.intellect25.realisation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class represent doubly-linked list. Implements methods of
 * <code>Iterable</code> interface.
 
 * @author Riabchenko Aliona
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(int index, T element) {
        insert(index, element);
    }

    /**
     * Returns iterator, that goes through element from end (in descending
     * order)
     *
     * @return iterator, that goes through element from end (in descending
     * order)
     */
    public Iterator<T> descendingIterator() {
        return new DescItr<T>();
    }

    /**
     * Nested class that represents Node of doubly-linked list.
     */
    private static class Node<T> {

        /**
         * Stored value
         */
        private T value;
        /**
         * Next node
         */
        private Node<T> next;
        /**
         * Previous node
         */
        private Node<T> prev;

        /**
         * Constructs Node with specified value
         *
         * @param value value for Node to store
         */
        public Node(T value) {
            this.value = value;
            next = null;
            prev = null;
        }
    }

    /**
     * First node in the list
     */
    private Node<T> first;
    /**
     * Last node in the list
     */
    private Node<T> last;
    /**
     * Number of elements in the list
     */
    private int size;

    /**
     * Insert specified element in the beginning of the list
     *
     * @param value value to add
     */
    public void addFirst(T value) {
        if (first != null) {
            Node<T> newFirst = new Node<T>(value);
            first.prev = newFirst;
            newFirst.next = first;
            first = newFirst;
        } else {
            first = new Node<T>(value);
            last = first;
        }
        size++;
    }

    /**
     * Insert specified element in the end of the list
     *
     * @param value value to add
     */
    public void addLast(T value) {
        if (first != null) {
            Node<T> newLast = new Node<T>(value);
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        } else {
            first = new Node<T>(value);
            last = first;
        }
        size++;
    }

    /**
     * Adds given value to the end of this list
     *
     * @param value value to add to list
     */
    public boolean add(T value) {
        addLast(value);
        return true;
    }

    /**
     * Get value from the list by specified index
     *
     * @param index index of specified element in list
     * @return value, that is stored at specified position in the list
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T get(int index) {
        checkIndexInRange(index);
        return node(index).value;
    }

    /**
     * Sets given value at specified index in the list.
     *
     * @param index index to set given value at
     * @param value value to be stored in the list
     * @return value that was stored at this position before
     * @throws IndexOutOfBoundsException if number is out of range
     */
    public T set(int index, T value) {
        checkIndexInRange(index);
        Node<T> node = node(index);
        T returnValue = node.value;
        node.value = value;
        return returnValue;
    }

    /**
     * Inserts given value at specified index in the list. Doesn't remove
     * anything.
     *
     * @param index index of given value to be inserted at
     * @param value value to be stored in the list
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public void insert(int index, T value) {
        checkIndexInRange(index);
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node<T> next = node(index);
        Node<T> prev = next.prev;
        Node<T> newNode = new Node<T>(value);

        next.prev = newNode;
        prev.next = newNode;
        newNode.next = next;
        newNode.prev = prev;
    }

    /**
     * Removes first element from the list
     *
     * @return value that was stored in the first element in the list
     */
    public T removeFirst() {
        if (first == null) {
            return null;
        }
        if (size == 1) {
            final T returnValue = first.value;
            clear();
            return returnValue;
        }

        T returnValue = first.value;
        first = first.next;
        first.prev = null;
        size--;
        return returnValue;
    }

    /**
     * Removes last element from the list
     *
     * @return value that was stored in the last element in the list
     */
    public T removeLast() {
        if (first == null) {
            return null;
        }
        if (size == 1) {
            final T returnValue = first.value;
            clear();
            return returnValue;
        }
        T returnValue = last.value;
        last = last.prev;
        last.next = null;
        size--;
        return returnValue;
    }

    /**
     * Removes value with specified index from the list
     *
     * @param index index with value to remove
     * @return removed value
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public T remove(int index) {
        checkIndexInRange(index);

        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node<T> node = node(index);
        T returnValue = node.value;
        Node<T> prev = node.prev;
        Node<T> next = node.next;

        next.prev = prev;
        prev.next = next;
        node = null;
        size--;

        return returnValue;
    }

    /**
     * Removes given value from the list if given value is in the list
     *
     * @param o value to remove from list
     * @return <code>true</code> if value was in the list and wsa removed;
     * <code>false</code> otherwise
     */
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        T value = (T) o;
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * Returns value that is first in the list
     *
     * @return value of the first element in the list
     * @throws NoSuchElementException if list is empty
     */
    public T getFirst() {
        final Node<T> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }
        return f.value;
    }

    /**
     * Returns value that is last in the list
     *
     * @return value of the last element in the list
     * @throws NoSuchElementException if list is empty
     */
    public T getLast() {
        final Node<T> l = last;
        if (l == null) {
            throw new NoSuchElementException();
        }
        return l.value;
    }

    /**
     * Returns index of first occurance of specified value in the list. If there
     * are no such element in the list - returns -1.
     *
     * @param value value to find in the list
     * @return index of first occurance of specified value in the list. If there
     * are no such element in the list - returns -1. Otherwise returns -1.
     */
    public int indexOf(Object value) {
        Node<T> currentNode = first;

        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (currentNode.value == null) {
                    return i;
                }
                currentNode = currentNode.next;
            }
        } else {
            T TValue = (T) value;
            for (int i = 0; i < size; i++) {
                if (Objects.equals(currentNode.value, TValue)) {
                    return i;
                }
                currentNode = currentNode.next;
            }
        }
        return -1;
    }

    /**
     * Return Node with specified index
     *
     * @param index index to find Node by
     * @return Node with specified index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    Node<T> node(int index) {
        checkIndexInRange(index);
        if (index == 0) {
            return first;
        }
        if (index == size - 1) {
            return last;
        }
        Node<T> current;
        if (index < size / 2) {
            current = first;
            for (int i = 1; i <= index; i++) {
                current = current.next;
            }
            return current;
        } else {
            current = last;
            for (int i = size - 2; i >= index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    /**
     * Check if given index is in range
     *
     * @param index index to check for fitting in range
     * @throws IndexOutOfBoundsException if index is out of range
     */
    private void checkIndexInRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
    }

    /**
     * Returns number of elements in the list
     *
     * @return number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if list is empty
     *
     * @return <code>true</code> if list is empty. <code>false</code> if list is
     * not empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new AscItr<T>();
    }


    private class AscItr<T> implements Iterator<T> {

        @SuppressWarnings("unchecked")
        Node<T> currentNode = (Node<T>) first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            Node<T> returnedNode = currentNode;
            currentNode = currentNode.next;
            return returnedNode.value;
        }

        public void remove() {
            if (size == 0) {
                throw new IllegalStateException("There are no elements in list "
                        + "to remove!");
            }

            if (currentNode == null) {
                if (last == first) {
                    last = null;
                    first = null;
                    size = 0;
                } else {
                    last = last.prev;
                    last.next = null;
                    size--;
                }
            } else if (currentNode.prev.prev == null) {
                first = first.next;
                first.prev = null;
                size--;
            } else {
                Node<T> newPrev = currentNode.prev.prev;
                newPrev.next = currentNode;
                currentNode.prev = newPrev;
                size--;
            }
        }

    }

    /**
     * Iterator, that goes through elements of list in descending order
     */
    private class DescItr<T> implements Iterator<T> {

        @SuppressWarnings("unchecked")
        Node<T> currentNode = (Node<T>) last;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            Node<T> returnedNode = currentNode;
            currentNode = currentNode.prev;
            return returnedNode.value;
        }

        public void remove() {
            if (size == 0) {
                throw new IllegalStateException("Iterator has not returned any "
                        + "element, so it can't remove anything!");
            }

            if (currentNode == null) {
                if (last == first) {
                    last = null;
                    first = null;
                    size = 0;
                } else {
                    first = first.next;
                    first.prev = null;
                    size--;
                }
            } else if (currentNode.next.next == null) {
                last = last.prev;
                last.next = null;
                size--;
            } else {
                Node<T> newNext = currentNode.next.next;
                newNext.prev = currentNode;
                currentNode.next = newNext;
                size--;
            }
        }
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
