package com.intellect25.entity;

/**
 * Mark is storing value of mark (,:?! and other)
 * Use into pattern COMPOSITE as leaf of Text
 *
 * @author Riabchenko Aliona
 */
public class Mark extends Text {

    /**
     * Value of mark
     */
    private String mark;

    /**
     * It adds data to the map of data
     *
     * @param data input data
     * @param <T> Object of data
     * @return the adding data
     */
    @Override
    public<T> T add(T data) {
        mark = (String) data;
        return data;
    }

    public String getMark() {
        return mark;
    }
}
