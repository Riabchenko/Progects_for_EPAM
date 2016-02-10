package com.intellect25.notebook.test;

import com.intellect25.notebook.Entity.Day;
import com.intellect25.notebook.Entity.Person;
import com.intellect25.notebook.Entity.Result;
import com.intellect25.notebook.controller.DataForTest;
import com.intellect25.notebook.model.NoteBook;
import junit.framework.TestCase;

/**
 * The NoteBookTest class
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class NoteBookTest extends TestCase implements DataForTest {

    public void testAddPerson() throws Exception {
        NoteBook noteBook = new NoteBook();
        noteBook.addPerson(LAST_NAME, FIRST_NAME, MIDLE_NAME, TELEPHONE,
                YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY);
        assertEquals(1,noteBook.size());

    }

    public void testCountDaysToBirthdayByName() throws Exception {
        NoteBook noteBook = new NoteBook();
        noteBook.addPerson(LAST_NAME, FIRST_NAME, MIDLE_NAME, TELEPHONE,
                YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY);

        Result<Person,Integer> result = noteBook.countDaysToBirthdayByName(LAST_NAME, FIRST_NAME, MIDLE_NAME);
        assertEquals(new Integer(2), result.getDaysToBirdhday());//need change parameter 2
    }

    public void testCountDaysToBirthdayByTelephone() throws Exception {
        NoteBook noteBook = new NoteBook();
        noteBook.addPerson(LAST_NAME, FIRST_NAME, MIDLE_NAME, TELEPHONE,
                YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY);

        Result<Person,Integer> result = noteBook.countDaysToBirthdayByTelephone(TELEPHONE);
        assertEquals(new Integer(2), result.getDaysToBirdhday());//need change parameter 2

    }

    public void testCountDaysToBirthday() throws Exception {
        NoteBook noteBook = new NoteBook();

        Person person = new Person();
        person.setLastName(LAST_NAME);
        person.setFirstName(FIRST_NAME);
        person.setMiddleName(MIDLE_NAME);
        person.setTelephone(TELEPHONE);
        person.setBirthday(new Day(YEAR_BIRTHDAY, MONTH_BIRTHDAY, DAY_BIRTHDAY));

        int result = noteBook.countDaysToBirthday(person);
        assertEquals(2,result); //need change parameter 2
    }
}