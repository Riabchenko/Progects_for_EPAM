package com.intellect25.notebook.controller;

import com.intellect25.notebook.model.FactoryForRunAnnotation;
import com.intellect25.notebook.Entity.Person;
import com.intellect25.notebook.Entity.Result;
import com.intellect25.notebook.view.MyWriter;

import java.util.Calendar;

/**
 * This class contains client to run program.
 * Program search annotations of methods and run
 * necessary methods.
 * Data for test and information messages stores in
 * interface DataForTest which implements here.
 *
 * @version 2.00
 * @author Riabchenko Aliona
 */
public class MainAnnotation implements DataForTest {

    /**
     * it's client
     *
     * @param args entered data
     */
    public static void main(String[]args){

        /* Show message 'Create contact and add it to notebook'*/
        MyWriter.show(CREATE_CONTACT);

        /* Show 'true' or 'false' that depends on result of execution of method*/
        MyWriter.show(""+ FactoryForRunAnnotation.add(LAST_NAME, FIRST_NAME, MIDLE_NAME, TELEPHONE, YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY));

        /* Show message 'Search contact by name'*/
        MyWriter.show(SEARCH_BY_NAME);

        /** Get result of execution of method*/
        Result<Person,Integer> resultName = FactoryForRunAnnotation.count(LAST_NAME, FIRST_NAME, MIDLE_NAME);

        /* Show result of execution of method - last name,first name,middle name, days to birthday */
        MyWriter.show(resultName.getPerson().getLastName() + " " + resultName.getPerson().getFirstName() + " " + resultName.getPerson().getMiddleName() +
                "\n"+MESSAGE + resultName.getDaysToBirdhday());

         /* Show message 'Search contact by telephone'*/
        MyWriter.show(SEARCH_BY_TELEPHONE);

        /** Get result of execution of method*/
        Result <Person,Integer> resultTelephone = FactoryForRunAnnotation.count(TELEPHONE);

         /* Show result of execution of method - last name,first name,middle name, days to birthday */
        MyWriter.show(resultTelephone.getPerson().getLastName()+" "+resultTelephone.getPerson().getFirstName()+" "+resultTelephone.getPerson().getMiddleName()+
                "\n"+resultTelephone.getPerson().getTelephone()+"\n"+
                resultTelephone.getPerson().getBirthday().getDate().get(Calendar.DATE)+" "+
                resultTelephone.getPerson().getBirthday().getDate().get(Calendar.MONTH)+" "+
                resultTelephone.getPerson().getBirthday().getDate().get(Calendar.YEAR)+" "+
                "\n" + MESSAGE + resultTelephone.getDaysToBirdhday());
    }
}
