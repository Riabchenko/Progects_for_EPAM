/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intellect25.test;

import com.intellect25.realisation.ArrayList;
import org.junit.*;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 *
 * @author Riabchenko Aliona
 */
public class ArrayArrayListTest {
    
    public ArrayArrayListTest() {
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

    @Test(expected = IllegalArgumentException.class)
    public void testCreateArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        assertEquals(0, list.size());
        int zero = 0;
        int ten = 10;
        int negativeCapacity = -1;
        assertEquals(0, new ArrayList<Integer>(zero).size());
        assertEquals(0, new ArrayList<Integer>(ten).size());
        new ArrayList<Integer>(negativeCapacity);
    }

    @Test
    public void testAddInEmptyArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        assertTrue(list.add(1));
        assertTrue(list.size() == 1);
    }

    @Test
    public void testAddElevenElements() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        assertTrue(list.size() == 11);
    }

    @Test
    public void testAddWithIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        list.add(5, 123);
        for(int i = 0; i < 5; i++) {
            assertEquals(new Integer(i), list.get(i));
        }
        assertEquals(new Integer(123), list.get(5));
        for(int i = 6; i < 11; i++) {
            assertEquals(new Integer(i - 1), list.get(i));
        }
        assertEquals(11, list.size());
    }
    
    
    
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetNegativeIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int negativeIndex = -1;
        list.set(negativeIndex, Integer.SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetTooBigIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int tooBigIndex = 100;
        list.set(tooBigIndex, Integer.SIZE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetOutByOneIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int outByOneIndex = list.size();
        list.set(outByOneIndex, outByOneIndex);
    }

    @Test
    public void testSetAllElements() {
        ArrayList<Integer> list = createDefaultArrayList();
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
        ArrayList<Integer> list = createDefaultArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            assertEquals(new Integer(i), list.set(i, null));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithNegativeIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int negativeIndex = -1;
        list.get(negativeIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithBiggerIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int biggerIndex = list.size();
        list.get(biggerIndex);
    }

    @Test
    public void testGetAllElementsByIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        for (int i = 0; i < 10; i++) {
            assertEquals(new Integer(i), list.get(i));
        }
    }

    @Test
    public void testCompareGetByIndexWithIterator() {
        ArrayList<Integer> list = createDefaultArrayList();
        Iterator<Integer> itr = list.iterator();
        for (int i = 0; i < 10; i++) {
            assertEquals(itr.next(), list.get(i));
        }
    }

    @Test
    public void testIndexOfExistingElement() {
        ArrayList<Integer> list = createDefaultArrayList();
        Integer value = 5;
        assertEquals(5, list.indexOf(value));
    }

    @Test
    public void testIndexOfUnexistingElement() {
        ArrayList<Integer> list = createDefaultArrayList();
        Integer value = -1;
        int defaultNoElementInListReturnedValue = -1;
        assertEquals(defaultNoElementInListReturnedValue, list.indexOf(value));
        value = 11;
        assertEquals(defaultNoElementInListReturnedValue, list.indexOf(value));
    }

    @Test
    public void testIndexOfNullThatIsInArrayList() {
        ArrayList<Integer> list = createDefaultArrayList();
        list.set(list.size() - 3, null);
        Integer value = null;
        int indexOfNull = list.size() - 3;
        assertEquals(indexOfNull, list.indexOf(value));
    }

    @Test
    public void testIndexOfNullThatIsNotInArrayList() {
        ArrayList<Integer> list = createDefaultArrayList();
        Integer value = null;
        int defaultNoElementInListReturnedValue = -1;
        assertEquals(defaultNoElementInListReturnedValue, list.indexOf(value));
    }

    @Test
    public void testRemoveByValue() {
        ArrayList<Integer> list = createDefaultArrayList();
        int sizeBeforeRemove = list.size();
        Integer valueToRemove = new Integer(5);
        assertTrue(list.remove(valueToRemove));
        assertEquals(sizeBeforeRemove - 1, list.size());
    }

    @Test
    public void testRemoveUnexistingValue() {
        ArrayList<Integer> list = createDefaultArrayList();
        int sizeBeforeRemove = list.size();
        Integer valueToRemove = new Integer(-1);
        assertFalse(list.remove(valueToRemove));
        assertEquals(sizeBeforeRemove, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByNegativeIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int negativeIndex = -1;
        list.remove(negativeIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveByTooBigIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int tooBigIndex = 100;
        list.remove(tooBigIndex);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutByOneIndex() {
        ArrayList<Integer> list = createDefaultArrayList();
        int outByOneIndex = list.size();
        list.remove(outByOneIndex);
    }

    @Test
    public void testRemoveByGoodIndeces() {
        ArrayList<Integer> list = createDefaultArrayList();
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
        ArrayList<Integer> list = createDefaultArrayList();
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
    public void iterateThroughTenElements() {
        ArrayList<Integer> list = createDefaultArrayList();
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
    public void removeWithIterator() {
        ArrayList<Integer> list = createDefaultArrayList();
        Iterator iter = list.iterator();
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
    public void testRemoveCurrentElementWithIterator() {
        ArrayList<Integer> list = createDefaultArrayList();
        Iterator iter = list.iterator();
        int i = 0;
        while (iter.hasNext()) {
            if (iter.next().equals(5)) {
                iter.remove();
            }
            i++;
        }
        iter = list.iterator();
        for (i = 0; i < 10; i++) {
            if (i == 5) {
                i++;
            }
            assertEquals(new Integer(i), iter.next());
        }
    }

    @Test
    public void testIsEmpty() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContainsTrue() {
        ArrayList<Integer> list = createDefaultArrayList();
        for(int i = 0; i < 10; i++) {
            assertTrue(list.contains(i));
        }
    }
    
    @Test
    public void testContainsFalse() {
        ArrayList<Integer> list = createDefaultArrayList();
        for(int i = 10; i < 20; i++) {
            assertFalse(list.contains(i));
        }
    }
    
    @Test
    public void testContainsNullTrue() {
        ArrayList<Integer> list = createDefaultArrayList();
        list.set(list.size() - 3, null);
        assertTrue(list.contains(null));
    }
    
    @Test
    public void testContainsNullFalse() {
        ArrayList<Integer> list = createDefaultArrayList();
        assertFalse(list.contains(null));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testClear() {
        ArrayList<Integer> list = createDefaultArrayList();
        assertEquals(10, list.size());
        assertEquals(new Integer(0), list.get(0));
        assertEquals(new Integer(9), list.get(list.size() - 1));
        list.clear();
        assertTrue(list.isEmpty());
        list.get(list.size());
    }
    
    
    private ArrayList<Integer> createDefaultArrayList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

}
