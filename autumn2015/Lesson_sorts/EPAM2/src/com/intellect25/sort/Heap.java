package com.intellect25.sort;

/**
 * The Heap class provides a static methods for heapsorting
 * an array.
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class Heap {

    // This class should not be instantiated.
    private Heap() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        int N = pq.length;
        for (int k = N / 2; k >= 1; k--)
            sink(pq, k, N);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    /**
     * Helper functions to restore the heap invariant.
     */
    private static void sink(Comparable[] pq, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(pq, j, j + 1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /**
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     *
     * @param pq Comparable[]
     * @param i index
     * @param j index
     * @return
     */
    private static boolean less(Comparable[] pq, int i, int j) {
        boolean bool = false;
        try {
            bool = pq[i - 1].compareTo(pq[j - 1]) < 0;
        } catch (NullPointerException ex) {

        }
        return bool;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        boolean bool = false;
        try {
            bool = v.compareTo(w) < 0;
        } catch (NullPointerException ex) {

        }
        return bool;
    }

    /**
     * Check if array is sorted - useful for debugging.
     *
     * @param a
     * @return false or true
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

}