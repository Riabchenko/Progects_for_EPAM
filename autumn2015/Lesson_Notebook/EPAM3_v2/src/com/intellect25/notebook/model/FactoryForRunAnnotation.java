package com.intellect25.notebook.model;

import com.intellect25.notebook.Entity.Result;

import java.util.LinkedList;

/**
 * The FactoryForRunAnnotation class
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class FactoryForRunAnnotation {

    /**
     * Private constructor
     */
    private FactoryForRunAnnotation(){}

    /**
     * Add person to list of persons
     *
     * @param lastName last name of person
     * @param firstName first name of person
     * @param middleName middle name of person
     * @param telephone telephone of person
     * @param year year of birthday
     * @param month month of birthday
     * @param day day of birthday
     * @return true or false
     */
    public static boolean add(String lastName, String firstName, String middleName,
                                String telephone, Integer year, Integer month, Integer day) {
        return AnnotationRunner.runAddPerson(NoteBook.class, lastName, firstName, middleName, telephone,
                year, month, day);
    }

    /**
     * Search person by telephone and count days to birthday
     *
     * @param lastName last name of person
     * @param firstName first name of person
     * @param middleName middle name of person
     * @param <P> Person
     * @param <I> Integer ,count of days
     * @return Result with Person  and Integer
     */
    public static <P,I> Result<P,I> count(String lastName, String firstName, String middleName) {
        return AnnotationRunner.countByName(NoteBook.class, lastName, firstName, middleName);
    }

    /**
     * Search person by telephone and count days to birthday
     *
     * @param telephone number of telephone
     * @param <P> Person
     * @param <I> Integer,count of days
     * @return Result with Person  and Integer
     */
    public static <P,I> Result<P,I> count(String telephone) {
        return AnnotationRunner.countByTelephone(NoteBook.class, telephone);
    }

    /**
     * Search all constructors and their parameters
     *
     * @param enteredClass entered class
     * @return list of result
     */
    public static LinkedList<String> start(Class enteredClass) {
        return AnnotationRunner.constructorSearch(NoteBook.class);
    }

}
