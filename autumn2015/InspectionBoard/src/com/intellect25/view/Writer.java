package com.intellect25.view;

import com.intellect25.entity.Form;
import com.intellect25.entity.Institute;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Writer for display information
 *
 * @author Riabchenko Aliona
 */
public class Writer {

    /** String ALL for display sum*/
    private final static String ALL = "All : ";

    /**
     * Display information from MAP
     *
     * @param map input data
     */
    public static void display(Map<String,Institute> map){
        List<String> size = new LinkedList<>();
        int sum = 0;

        for (Map.Entry<String,Institute> entity : map.entrySet()){
            System.out.println("===============================================================");
            System.out.println("\n"+entity.getKey()+"\n");

            Queue<Form> forms = entity.getValue().getList();
            size.add(entity.getKey()+" - "+forms.size());
            sum += forms.size();

            for (Form form : forms){
                System.out.println("--------------------------------------");
                System.out.println(form.getId());
                System.out.println(form.getFirstName()+" "+form.getLastName());
                System.out.println(form.getExamFirst() + " " + form.getExamSecond() + " " + form.getExamThird());
            }
        }
        System.out.println("===============================================================");
        for (String string : size)
            System.out.println(string);
        System.out.println(ALL+sum);
        System.out.println("===============================================================");
    }
}
