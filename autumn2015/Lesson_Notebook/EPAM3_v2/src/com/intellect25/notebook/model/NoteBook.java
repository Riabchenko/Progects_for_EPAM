package com.intellect25.notebook.model;

import com.intellect25.notebook.Entity.Day;
import com.intellect25.notebook.Entity.Person;
import com.intellect25.notebook.Entity.Result;

import java.util.ArrayList;

/**
 * The NoteBook class count days to birthday
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class NoteBook extends Day {
    private ArrayList<Person> persons = new ArrayList<>();

    /**
     * Constructor default
     */
    public NoteBook(){

    }

    /**
     * Use this constructor for set all information about person
     * and date(if you don't use current day)
     *
     * @param persons Person
     */
    public NoteBook(ArrayList<Person> persons){
        this.persons = persons;
    }

    /**
     * Add person to the notebook
     *
     * @param lastName last name of person
     * @param firstName first name of person
     * @param middleName middle name of person
     * @param telephone telephone of person
     * @param year year of birthday
     * @param mount month of birthday
     * @param day day of birthday
     */
    @MethodNoteBook(name = "add", description = "all")
    public void addPerson(String lastName,String firstName,String middleName,
                          String telephone,Integer year, Integer mount,Integer day){

        /* check parameters */
        isNull(lastName, firstName, middleName, telephone,
                year, mount, day);

        /* create Person*/
        Person person = new Person();
        person.setLastName(lastName);
        person.setFirstName(firstName);
        person.setMiddleName(middleName);
        person.setTelephone(telephone);
        Day birthday = new Day(year,mount,day);
        person.setBirthday(birthday);

        /*Add person to list of persons*/
        persons.add(person);
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
    @MethodNoteBook(name = "count", description = "name")
    public <P,I> Result<P,I> countDaysToBirthdayByName(String lastName,String firstName,String middleName){
        isNull(lastName, firstName, middleName);
        for (Person person : persons){
            if ((person.getLastName() == lastName) && (person.getFirstName() == firstName) &&
                    (person.getMiddleName()==middleName) ){
                return new Result(person,countDaysToBirthday(person));
            }
        }
        return null;
    }

    /**
     * Search person by telephone and count days to birthday
     *
     * @param telephone number of telephone
     * @param <P> Person
     * @param <I> Integer,count of days
     * @return Result with Person  and Integer
     */
    @MethodNoteBook(name = "count", description = "telephone")
    public <P,I> Result<P,I> countDaysToBirthdayByTelephone(String telephone){
        isNull(telephone);

        for (Person person : persons){
            if (person.getTelephone() == telephone){

                return new Result(person,countDaysToBirthday(person));
            }
        }
        return null;
    }

    /**
     *  Count days to birthday
     *
     * @param person Person
     * @return amount of days
     */
    @MethodNoteBook(name = "count", description = "main")
    public int countDaysToBirthday(Person person){
        Day today = new Day();
        int i = -1;
        if (person.getBirthday() != null){
           i = person.getBirthday().getDayOfYear() - today.getDayOfYear();

            if(i < 0){
                i = i + today.getDayOfYear();
            }
        }
        return i;
    }

    /**
     * Check parameters is null or isn't null
     *
     * @param objects entered parameter
     * @param <T> type of parameter
     * @return fixed parameters
     */
    @MethodNoteBook(name = "check")
    private <T> T[] isNull(T... objects){
        for (T object : objects) {
            if (object instanceof String) {
                if (object == null) object = (T) "";
            }

            if (object instanceof Integer) {
                if (object == null) {
                    throw new NullPointerException("Date is null!");
                }
            }
        }
        return objects;
    }

    /**
     * Return size of list of persons
     *
     * @return size
     */
    public int size(){
        return persons.size();
    }


}
