package com.intellect25.entity;

/**
 * Code is storing value of code
 * Use into pattern COMPOSITE as leaf of Data
 *
 * @author Riabchenko Aliona
 */
public class Code extends Data {

    /**
     * Value of code
     */
    private String code;

    /**
     * Get value of code
     *
     * @return code
     */
    public String getCode(){
        return code;
    }

    /**
     * It adds data to the map of data
     *
     * @param data input data
     * @param <T> Object of data
     * @return the adding data
     */
    @Override
    public<T> T add( T data) {
        code = (String) data;
        return data;
    }

}
