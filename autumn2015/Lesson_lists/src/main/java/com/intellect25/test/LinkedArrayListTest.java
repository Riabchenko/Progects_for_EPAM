/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellect25.test;

import com.intellect25.realisation.LinkedList;
import org.junit.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 *
 * @author Riabchenko Aliona
 */
public class LinkedArrayListTest {
    
    public LinkedArrayListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCreateLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void testAddLastInEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Integer value = 1;
        list.addLast(value);
        assertTrue(list.size() == 1);
        assertEquals(list.getFirst(), list.getLast());
        assertEquals(value, list.getFirst());
        assertEquals(new Integer(1), list.getLast());
    }

    @Test
    public void testAddLastElevenElements() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 11; i++) {
            list.addLast(i);
        }
        assertTrue(list.size() == 11);
    }

    @Test
    public void testAddFirstElevenElements() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 11; i++) {
            list.addFirst(i);
        }
        assertTrue(list.size() == 11);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetFirstFromEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.getFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetLastFromEmptyLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.getLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegativeIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int negativeIndex = -1;
        list.set(negativeIndex, Integer.SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetTooBigIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int tooBigIndex = 100;
        list.set(tooBigIndex, Integer.SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutByOneIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int outByOneIndex = list.size();
        list.set(outByOneIndex, outByOneIndex);
    }

    @Test
    public void testSetAllElements() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, size);
        }
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            assertEquals(size, itr.next());
        }
    }

    @Test
    public void testSetAllElementsNull() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            assertEquals(new Integer(i), list.set(i, null));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithNegativeIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int negativeIndex = -1;
        list.get(negativeIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithBiggerIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int biggerIndex = list.size();
        list.get(biggerIndex);
    }

    @Test
    public void testGetAllElementsByIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        for (int i = 0; i < 10; i++) {
            assertEquals(new Integer(i), list.get(i));
        }
    }

    @Test
    public void testCompareGetByIndexWithIterator() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator<Integer> itr = list.iterator();
        for (int i = 0; i < 10; i++) {
            assertEquals(itr.next(), list.get(i));
        }
    }

    @Test
    public void testIndexOfExistingElement() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Integer value = 5;
        assertEquals(5, list.indexOf(value));
    }

    @Test
    public void testIndexOfUnexistingElement() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Integer value = -1;
        int defaultNoElementInListReturnedValue = -1;
        assertEquals(defaultNoElementInListReturnedValue, list.indexOf(value));
        value = 11;
        assertEquals(defaultNoElementInListReturnedValue, list.indexOf(value));
    }

    @Test
    public void testIndexOfNullThatIsInLinkedList() {
        LinkedList<Integer> list = createDefaultLinkedList();
        list.set(list.size() - 3, null);
        Integer value = null;
        int indexOfNull = list.size() - 3;
        assertEquals(indexOfNull, list.indexOf(value));
    }

    @Test
    public void testIndexOfNullThatIsNotInLinkedList() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Integer value = null;
        int defaultNoElementInListReturnedValue = -1;
        assertEquals(defaultNoElementInListReturnedValue, list.indexOf(value));
    }

    @Test
    public void testRemoveByValue() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int sizeBeforeRemove = list.size();
        Integer valueToRemove = 5;
        assertTrue(list.remove(valueToRemove));
        assertEquals(sizeBeforeRemove - 1, list.size());
    }

    @Test
    public void testRemoveUnexistingValue() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int sizeBeforeRemove = list.size();
        Integer valueToRemove = -1;
        assertFalse(list.remove(valueToRemove));
        assertEquals(sizeBeforeRemove, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByNegativeIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int negativeIndex = -1;
        list.remove(negativeIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByTooBigIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int tooBigIndex = 100;
        list.remove(tooBigIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutByOneIndex() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int outByOneIndex = list.size();
        list.remove(outByOneIndex);
    }

    @Test
    public void testRemoveByGoodIndeces() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int goodIndex = list.size() - 1;
        assertEquals(new Integer(9), list.remove(goodIndex));
        goodIndex = 0;
        assertEquals(new Integer(0), list.remove(goodIndex));
        assertEquals(new Integer(8), list.get(list.size() - 1));
        assertEquals(new Integer(2), list.get(1));
        assertEquals(8, list.size());
    }

    @Test
    public void testAddAfterRemove() {
        LinkedList<Integer> list = createDefaultLinkedList();
        int goodIndex = list.size() - 1;
        assertEquals(new Integer(9), list.remove(goodIndex));
        goodIndex = 0;
        assertEquals(new Integer(0), list.remove(goodIndex));
        assertEquals(8, list.size());
        list.add(12);
        assertEquals(9, list.size());
        assertEquals(new Integer(12), list.get(8));
    }

    @Test
    public void iterateAscThroughTenElements() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator iter = list.iterator();
        int i = 0;
        while (iter.hasNext()) {
            assertEquals(iter.next(), i);
            i++;
        }
        iter = list.iterator();
        for (i = 0; i < 10; i++) {
            assertEquals(i, iter.next());
        }
    }

    @Test
    public void iterateDescThroughTenElements() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator iter = list.descendingIterator();
        int i = 9;
        while (iter.hasNext()) {
            assertEquals(iter.next(), i);
            i--;
        }
        iter = list.descendingIterator();
        for (i = 9; i >= 0; i--) {
            assertEquals(i, iter.next());
        }
    }
    
    @Test
    public void removeWithAscIterator() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator<Integer> iter = list.iterator();
        int i = 0;
        while (iter.hasNext()) {
            iter.next();
            if (i % 2 == 1) {
                iter.remove();
            }
            i++;
        }

        iter = list.iterator();
        Integer[] arr = new Integer[]{0, 2, 4, 6, 8};
        for (i = 0; i < arr.length; i++) {
            assertEquals(arr[i], iter.next());
        }
        assertEquals(5, list.size());
    }

    @Test
    public void removeWithDescIterator() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator<Integer> iter = list.descendingIterator();
        int i = 9;
        while (iter.hasNext()) {
            iter.next();
            if (i % 2 == 1) {
                iter.remove();
            }
            i--;
        }

        iter = list.descendingIterator();
        Integer[] arr = new Integer[]{8, 6, 4, 2, 0};
        for (i = 0; i < arr.length; i++) {
            assertEquals(arr[i], iter.next());
        }
        assertEquals(5, list.size());
    }
    
    @Test
    public void testRemoveCurrentElementWithAscIterator() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(5)) {
                iter.remove();
            }
        }
        iter = list.iterator();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                i++;
            }
            assertEquals(new Integer(i), iter.next());
        }
    }

    @Test
    public void testRemoveCurrentElementWithDescIterator() {
        LinkedList<Integer> list = createDefaultLinkedList();
        Iterator<Integer> iter = list.descendingIterator();
        while (iter.hasNext()) {
            if (iter.next().equals(5)) {
                iter.remove();
            }
        }
        iter = list.descendingIterator();
        for (int i = 9; i >= 0; i--) {
            if (i == 5) {
                i--;
            }
            assertEquals(new Integer(i), iter.next());
        }
    }
    
    
    @Test
    public void testIsEmptyWithAscIterator() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        assertTrue(list.isEmpty());
    }
    
    @Test
    public void testIsEmptyWithDescIterator() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iter = list.descendingIterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        assertTrue(list.isEmpty());
    }
    
    @Test
    public void testContainsTrue() {
        LinkedList<Integer> list = createDefaultLinkedList();
        for(int i = 0; i < 10; i++) {
            assertTrue(list.contains(i));
        }
    }
    
    @Test
    public void testContainsFalse() {
        LinkedList<Integer> list = createDefaultLinkedList();
        for(int i = 10; i < 20; i++) {
            assertFalse(list.contains(i));
        }
    }
    
    @Test
    public void testContainsNullTrue() {
        LinkedList<Integer> list = createDefaultLinkedList();
        list.set(list.size() - 3, null);
        assertTrue(list.contains(null));
    }
    
    @Test
    public void testContainsNullFalse() {
        LinkedList<Integer> list = createDefaultLinkedList();
        assertFalse(list.contains(null));
    }
    
    @Test
    public void testClear() {
        LinkedList<Integer> list = createDefaultLinkedList();
        assertEquals(10, list.size());
        assertEquals(new Integer(0), list.getFirst());
        assertEquals(new Integer(9), list.getLast());
        list.clear();
        assertTrue(list.isEmpty());
        try {
            list.getFirst();
            assertTrue(false);
        } catch (NoSuchElementException ex) {
            assertTrue(true);
        }
        try {
            list.getLast();
            assertTrue(false);
        } catch (NoSuchElementException ex) {
            assertTrue(true);
        }
    }
    
    private LinkedList<Integer> createDefaultLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }
    

}
