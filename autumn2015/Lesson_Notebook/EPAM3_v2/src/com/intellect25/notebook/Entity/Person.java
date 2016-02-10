package com.intellect25.notebook.Entity;

/**
 * This class stores a data of person
 *
 * @version 2.00
 * @author Riabchenko Aliona
 */
public class Person {

    /** Last name of person */
    private String lastName;

    /** First name of person */
    private String firstName;

    /** Middle name of person */
    private String middleName;

    /** Telephon number of person */
    private String telephone;

    /** Birthday of person */
    private Day birthday;

    /**
     * Get last name
     *
     * @return last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name
     *
     * @param lastName entered last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get firs name
     *
     * @return first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name
     *
     * @param firstName entered first name of the person
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get middle name
     *
     * @return middle name of the person
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set middle name
     *
     * @param middleName entered middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Get telephone number
     *
     * @return telephone number
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Set telephone number
     *
     * @param telephone entered telephone number
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Get birthday of person
     *
     * @return Day of birthday
     */
    public Day getBirthday() {
        return birthday;
    }

    /**
     * Set birthday of person
     *
     * @param birthday Day of birthday
     */
    public void setBirthday(Day birthday) {
        this.birthday = birthday;
    }
}
