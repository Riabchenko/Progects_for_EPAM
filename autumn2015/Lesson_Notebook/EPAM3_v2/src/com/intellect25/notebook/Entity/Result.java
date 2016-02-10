package com.intellect25.notebook.Entity;

/**
 * This class stores result of execution of methods
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class Result <P,I>{

    /** Usually object of Person, but can be other*/
    private P person;

    /**
     * Usually Integer which stores information about count
     * of days to birthday,but can be other
     */
    private I daysToBirdhday;

    /**
     * Default constructor
     */
    public Result() {
    }

    /**
     * Constructor with entered parameters
     *
     * @param person object of Person
     * @param daysToBirdhday  information about count of days to birthday
     */
    public Result(P person, I daysToBirdhday) {
        this.person = person;
        this.daysToBirdhday = daysToBirdhday;
    }


    /**
     * Get a Person from Result
     *
     * @return object of person
     */
    public P getPerson() {
        return person;
    }

    /**
     * Set a Person to Result
     *
     * @param person object of Person
     */
    public void setPerson(P person) {
        this.person = person;
    }

    /**
     * Get a count of days to birthday from Result
     *
     * @return count of days to birthday
     */
    public I getDaysToBirdhday() {
        return daysToBirdhday;
    }

    /**
     * Set a count of days to birthday to Result
     *
     * @param daysToBirdhday count of days to birthday
     */
    public void setDaysToBirdhday(I daysToBirdhday) {
        this.daysToBirdhday = daysToBirdhday;
    }
}
