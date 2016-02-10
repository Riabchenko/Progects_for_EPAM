package com.intellect25.notebook;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * The NoteBook class count days to birthday
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class NoteBook extends Day {

    /** Last name  */
    private String lastName;

    /** First name */
    private String firstName;

    /**  Middle name*/
    private String middleName;

    /** Number of telephone */
    private String telephone;

    /** Date of birthday*/
    private Calendar birthday;

    /**
     * Constructor default
     */
    public NoteBook(){

    }

    /**
     * Use this constructor for set all information about person
     * and date(if you don't use current day)
     *
     * @param lastName last name
     * @param firstName first name
     * @param middleName middle name
     * @param telephone telephone
     * @param year year
     * @param mount mount
     * @param day day
     * @param yearNow now year
     * @param mountNow now mount
     * @param dayNow today
     */
    public NoteBook(String lastName,String firstName,String middleName,
                    String telephone,Integer year, Integer mount,Integer day,
                    Integer yearNow, Integer mountNow,Integer dayNow){
        super(yearNow,mountNow,dayNow);
        initialisation(lastName, firstName, middleName, telephone,
                year, mount, day);
    }

    /**
     * Use this constructor for set all information about person
     *
     * @param lastName last name
     * @param firstName first name
     * @param middleName middle name
     * @param telephone telephone
     * @param year year
     * @param mount mount
     * @param day day
     */
    public NoteBook(String lastName,String firstName,String middleName,
                    String telephone,Integer year, Integer mount,Integer day){
        initialisation(lastName, firstName, middleName, telephone,
                year, mount, day);
    }

    /**
     * Initialisation field
     *
     * @param lastName last name
     * @param firstName first name
     * @param middleName middle name
     * @param telephone telephone
     * @param year year
     * @param mount mount
     * @param day day
     */
    @MethodNoteBook(description = "check")
    private void initialisation(String lastName,String firstName,String middleName,
                                    String telephone,Integer year, Integer mount,Integer day){
        isNull(lastName, firstName, middleName, telephone,
                year, mount, day);
        setLastName(lastName);
        setFirstName(firstName);
        setMiddleName(middleName);

        setTelephone(telephone);

        setBirthday(year, mount, day);
    }

    /**
     * Count days to birthday
     *
     * @return amount of days
     */
    @MethodNoteBook(name = 6, description = "Count days to birthday")
    public int countDaysToBirthday(){
        int i = -1;
        if (getBirthday() != null){
           i = getBirthday().
                get(Calendar.DAY_OF_YEAR) - getDayOfYear();

            if(i < 0){
                i = i + Calendar.
                   getInstance(TimeZone.getTimeZone("GMT")).
                   get(Calendar.DAY_OF_YEAR);
            }
        }
        MyWriter.show(" "+i);
        return i;
    }

    /**
     * Check parameters is null or isn't null
     *
     * @param objects entered parameter
     * @param <T> type of parameter
     * @return fixed parameters
     */
    @MethodNoteBook(description = "check")
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
     * get lastName
     * @return lastName
     */
    @MethodNoteBook(description = "get")
    public String getLastName() {
        return lastName;
    }

    /**
     * set last name
     *
     * @param lastName entered last name
     */
    @MethodNoteBook(name = 1, description = "set")
    public void setLastName(String lastName) {
        isNull(lastName);
        this.lastName = lastName;
    }

    /**
     * get first name
     *
     * @return first name
     */
    @MethodNoteBook(description = "get")
    public String getFirstName() {
        return firstName;
    }

    /**
     * set first name
     *
     * @param firstName entered first name
     */
    @MethodNoteBook(name = 2,description = "set")
    public void setFirstName(String firstName) {
        isNull(firstName);
        this.firstName = firstName;
    }

    /**
     * get middle name
     *
     * @return middle name
     */
    @MethodNoteBook(description = "get")
    public String getMiddleName() {
        return middleName;
    }

    /**
     * set middle name
     *
     * @param middleName entered middle name
     */
    @MethodNoteBook(name = 3,description = "set")
    public void setMiddleName(String middleName) {
        isNull(middleName);
        this.middleName = middleName;
    }

    /**
     * get telephone
     *
     * @return telephone
     */
    @MethodNoteBook(description = "get")
    public String getTelephone() {
        return telephone;
    }

    /**
     * set telephone
     *
     * @param telephone entered telephone
     */
    @MethodNoteBook(name = 4,description = "set")
    public void setTelephone(String telephone) {
        isNull(telephone);
        this.telephone = telephone;
    }

    /**
     * set birthday
     *
     * @param year entered year
     * @param mount entered mount
     * @param day entered day
     */
    @MethodNoteBook(name = 5,description = "set")
    void setBirthday(Integer year, Integer mount,Integer day){
        isNull(day,mount,day);
        birthday = Calendar.getInstance();
        birthday.set(year, mount, day);
    }

    /**
     * get birthday
     *
     * @return birthday
     */
    @MethodNoteBook(description = "get")
    public Calendar getBirthday() {
        return birthday;
    }

}
