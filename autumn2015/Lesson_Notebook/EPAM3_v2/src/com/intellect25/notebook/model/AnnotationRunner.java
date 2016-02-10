package com.intellect25.notebook.model;

import com.intellect25.notebook.Entity.Result;
import com.intellect25.notebook.view.MyWriter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * The AnnotationRunner class has methods to search methods,
 * constructors and annotations in class. Also annotations
 * invokes methods from class.
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class AnnotationRunner {

    /**
     * Map stores methods and their annotations
     */
    static Map<MethodNoteBook, Method> map = new LinkedHashMap<>();

    /**
     * Instance of NoteBook class
     */
    private  static NoteBook newInstance = init(NoteBook.class);


    /**
     * Create instance of NoteBook class
     *
     * @param myClass entered class
     * @param <T> class
     * @return instance of class
     */
    private static  <T> T init(Class<T> myClass) {
        Class classNoteBook = myClass;

        /* Create null reference to instance of class */
        T newInstance = null;
        try {
            newInstance = (T) classNoteBook.getConstructor().newInstance();

            /* Put all methods of class to map*/
            for (Method methodNoteBook : myClass.getDeclaredMethods()) {
                MethodNoteBook methodClass = methodNoteBook.getAnnotation(MethodNoteBook.class);

                if (methodClass != null)
                   map.put(methodClass, methodNoteBook);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return newInstance;
    }

    /**
     * Add person to list of persons
     *
     * @param myClass class
     * @param lastName last name of person
     * @param firstName first name of person
     * @param middleName middle name of person
     * @param telephone telephone of person
     * @param year year of birthday
     * @param month month of birthday
     * @param day day of birthday
     * @return true or false
     */
    public static boolean runAddPerson(Class<?> myClass,String lastName,String firstName,String middleName,
                                                 String telephone,Integer year,Integer month,Integer day){
        boolean result = false; //result


        try {

            /* Invoke methods */
            for (Map.Entry<MethodNoteBook, Method> el : map.entrySet()) {
                if (el.getKey().name().compareTo("add") == 0) {
                    el.getValue().invoke(newInstance, lastName, firstName, middleName, telephone,
                            year, month, day);
                    result = true;

                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Search person by telephone and count days to birthday
     *
     * @param myClass enered class
     * @param telephone number of telephone
     * @param <P> Person
     * @param <I> Integer,count of days
     * @return Result with Person  and Integer
     */
    public static <P,I> Result<P,I> countByTelephone(Class<?> myClass,String telephone){
        int result = -1;

            /* Invoke methods */
            for (Map.Entry<MethodNoteBook, Method> el : map.entrySet()) {
                if (el.getKey().name().compareTo("count") == 0 && el.getKey().description().compareTo("telephone") == 0  ) {
                    try {
                        return (Result) el.getValue().invoke(newInstance,telephone);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        return null;
        }

    /**
     * Search person by telephone and count days to birthday
     *
     * @param myClass entered class
     * @param lastName last name of person
     * @param firstName first name of person
     * @param middleName middle name of person
     * @param <P> Person
     * @param <I> Integer ,count of days
     * @return Result with Person  and Integer
     */
    public static <P,I> Result<P,I> countByName(Class<?> myClass,String lastName,String firstName,String middleName){

            /* Invoke methods */
            for (Map.Entry<MethodNoteBook, Method> el : map.entrySet()) {
                if (el.getKey().name().compareTo("count") == 0 && el.getKey().description().compareTo("name") == 0  ) {
                    try {
                        return (Result) el.getValue().invoke(newInstance, lastName, firstName, middleName);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        return null;
        }

    /**
     * This method searches all constructors of class
     * and parameters of constructor
     *
     * @param enteredClass class which we'll explore
     * @return list of result
     */
    public static LinkedList<String> constructorSearch(Class enteredClass){
        LinkedList<String> result = new LinkedList<>();//array with result
        Class classNoteBook = enteredClass;

        /* get amount of modifiers */
        int modifiers = classNoteBook.getModifiers();

        /* find modifiers for class */
        if (Modifier.isPublic(modifiers)) {
            result.add("Class is public");
        }

        else if (Modifier.isAbstract(modifiers)) {
            MyWriter.show("Class is abstract");
        }

        else if (Modifier.isFinal(modifiers)) {
            result.add("Class is final");
        }

        /* get all constructors of class */
        Constructor[] allConstructors = classNoteBook.getDeclaredConstructors();

        for (Constructor constructor : allConstructors) {
            int number = 0;
            result.add(constructor.toGenericString());

            /* get all type of parameters of constructor */
            Class[] parameterTypes = constructor.getParameterTypes();

            for (Class param : parameterTypes) {
                result.add(number++ +""+ param);
            }
        }
        return result;
    }


}
