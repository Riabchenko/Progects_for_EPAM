package com.intellect25.model;

import com.intellect25.entity.Stone;

import java.util.Comparator;

/**
 * Comparators to sorts Stone
 *
 * @author Riabchenko Aliona
 */
public enum  ComparatorsForSort {
    BY_ID(new Comparator<Stone>() {
        @Override
        public int compare(Stone o1, Stone o2) {
            return o1.getId().compareTo(o2.getId());
        }
    }),

    BY_NAME(new Comparator<Stone>() {
        @Override
        public int compare(Stone o1, Stone o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }),

    BY_PRECIOUSNESS(new Comparator<Stone>() {
        @Override
        public int compare(Stone o1, Stone o2) {
            return o1.getPreciousness().compareTo(o2.getPreciousness());
        }
    });

    /** Store comparator */
    private Comparator<Stone> comparator;

    /**
     * Constructor
     *
     * @param comparator comparator for stone
     */
    ComparatorsForSort(Comparator<Stone> comparator) {
        this.comparator = comparator;
    }

    /**
     * Get comparator for stone
     *
     * @return comparator
     */
    public Comparator<Stone> getComparator(){
        return comparator;
    }
}
