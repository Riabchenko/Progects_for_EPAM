package com.intellect25.notebook.controller;

import com.intellect25.notebook.Entity.Person;
import com.intellect25.notebook.Entity.Result;
import com.intellect25.notebook.model.NoteBook;
import com.intellect25.notebook.view.MyWriter;

/**
 * This class contains client to simple run program.
 * Data for test and information messages stores in
 * interface DataForTest which implements here.
 *
 * @version 2.00
 * @author Riabchenko Aliona
 */
public class MainGeneneral implements DataForTest {

    /**
     * it's client
     *
     * @param args entered data
     */
    public static void main(String[]args){

        /* Create NoteBook */
        NoteBook noteBook = new NoteBook();

        /* Add person to notebook*/
        noteBook.addPerson(LAST_NAME, FIRST_NAME, MIDLE_NAME, TELEPHONE,
                YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY);

        /* Get result by telephone number*/
        Result<Person,Integer> resultByTelephone = noteBook.countDaysToBirthdayByTelephone(TELEPHONE);

       /* Show result of execution of method - last name,first name,middle name, days to birthday */
        MyWriter.show(resultByTelephone.getPerson().getLastName() + " " + resultByTelephone.getPerson().getFirstName() + " "
                + resultByTelephone.getPerson().getMiddleName() + "\n" + MESSAGE + resultByTelephone.getDaysToBirdhday());

        /* Get result by name */
        Result<Person,Integer> resultByName = noteBook.countDaysToBirthdayByTelephone(TELEPHONE);

       /* Show result of execution of method - last name,first name,middle name, days to birthday */
        MyWriter.show(resultByName.getPerson().getLastName() + " " + resultByName.getPerson().getFirstName() + " "
                + resultByName.getPerson().getMiddleName() + "\n" + MESSAGE + resultByName.getDaysToBirdhday());

    }
}
