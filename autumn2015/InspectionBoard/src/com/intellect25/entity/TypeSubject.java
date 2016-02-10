package com.intellect25.entity;

/**
 * Enum of subject with them codes
 *
 * @author Riabchenko Aliona
 */
public enum TypeSubject {

    UKRAINE_LANGUAGE(1),

    BIOLOGY(2), CHEMISTRY(3),

    MATHEMATICS(4), PHYSICS(5);

    /** Code of subject for counting hash */
    private int code;

    /** Constructor */
    TypeSubject(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
