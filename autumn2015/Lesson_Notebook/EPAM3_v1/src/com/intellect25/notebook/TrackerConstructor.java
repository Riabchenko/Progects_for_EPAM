package com.intellect25.notebook;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * The TrackerConstructor class has methods to search methods,
 * constructors and annotations in class. Also annotations
 * invokes methods from class.
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class TrackerConstructor {

    /**
     * The method creates instance of class myClass,
     * search all methods and their annotations,
     * than it executes need methods
     *
     * @param myClass class which we'll create
     * @param year year of birthday
     * @param month month of birthday
     * @param day day of birthday
     * @return list of result
     */
    public static LinkedList<String> trackMethod(Class<?> myClass,Integer year,Integer month,Integer day){
        LinkedList<String> result = null;//array with result

        /*
         * Map stores methods and their annotations
         * Data are store sorted by MethodNoteBook,
         * because this annotation is describe
         * the queue of executions of methods and
         * descriptions
         */
        Map<MethodNoteBook, Method> map = new TreeMap<MethodNoteBook, Method>(
                new Comparator<MethodNoteBook>() {

                    @Override
                    public int compare(MethodNoteBook o1, MethodNoteBook o2) {
                        return o1.name() - (o2.name());
                    }

                });

        try {
            Class classNoteBook = NoteBook.class;

            /* Create instance of class */
            NoteBook newInstance = (NoteBook) classNoteBook.getConstructor().newInstance();

            /* Put all methods of class to map*/
            for (Method methodNoteBook : myClass.getDeclaredMethods()){
                MethodNoteBook methodClass = methodNoteBook.getAnnotation(MethodNoteBook.class);
                map.put(methodClass,methodNoteBook);
            }

            result = new LinkedList<String>();

            /* Invoke methods */
            for (Map.Entry<MethodNoteBook, Method> el : map.entrySet()) {
                if (el.getKey().description().compareTo("set") == 0) {
                    switch (el.getKey().name()) {
                        case 1: //name() of annotation return 1 , so, the first, execute this method
                            result.add("1 " + el.getValue().getName() + " : " + el.getKey().description());
                            el.getValue().invoke(newInstance, new String("lastName"));
                            continue;
                        case 2://name() of annotation return 2 , so ,the second, execute this method
                            result.add("2 " + el.getValue().getName() + " : " + el.getKey().description());
                            el.getValue().invoke(newInstance, new String("firstName"));
                            continue;
                        case 3:
                            result.add("3 " + el.getValue().getName() + " : " + el.getKey().description());
                            el.getValue().invoke(newInstance, new String("middleName"));
                            continue;
                        case 4:
                            result.add("4 " + el.getValue().getName() + " : " + el.getKey().description());
                            el.getValue().invoke(newInstance, new String("telephone"));
                            continue;
                        case 5:
                            result.add("5 " + el.getValue().getName() + " : " + el.getKey().description());
                            el.getValue().invoke(newInstance, new Integer(year), new Integer(month), new Integer(day));
                            continue;
                    }
                } else if (el.getKey().name() == 6 && el.getKey().description().compareTo("Count days to birthday") == 0) {
                    result.add("6 " + el.getValue().getName() + " : " + el.getKey().description());
                    el.getValue().invoke(newInstance);
                }
            }
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        return result;
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
            result.add("Constructor: " + constructor.toGenericString());

            /* get all type of parameters of constructor */
            Class[] parameterTypes = constructor.getParameterTypes();

            for (Class param : parameterTypes) {
                result.add("    GenericParameterType [" + number++ + "]: " + param);
            }
        }
        return result;
    }


}
