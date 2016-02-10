package com.intellect25.notebook.Entity;


import com.intellect25.notebook.model.MethodNoteBook;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * This class stores a date and can generate current date
 *
 * @version 2.00
 * @author Riabchenko Aliona
 */
public class Day {

    /** It stores a date as Calendar */
    private Calendar date;

    /**
     * It's constructor without parameters.
     * It creates object with a current date and
     * pass it to constructor which has entered parameter Calendar.
     */
    public Day(){
        this(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
    }

    /**
     * It's constructor with entered a date Calendar
     *
     * @param date currentDate
     */
    public Day(Calendar date){
        setDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
                date.get(Calendar.DATE));
    }

    /**
     * It's constructor with entered yearNow,mountNow,dayNow.
     * It invokes method to set a date.
     *
     * @param yearNow entered parameter of year
     * @param mountNow entered parameter of month
     * @param dayNow entered parameter of day
     */
    public Day(Integer yearNow, Integer mountNow,Integer dayNow) {
        setDate(yearNow, mountNow-1, dayNow);
    }

    /**
     * Get day of year
     *
     * @return amount of days from begin of year
     */
    @MethodNoteBook(description = "get")
    public int getDayOfYear(){
        return date.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Get date
     *
     * @return date
     */
    @MethodNoteBook(description = "get")
    public Calendar getDate() {
        return date;
    }

    /**
     * Set current date
     *
     * @param year year which necessary save
     * @param mount mount which necessary save
     * @param day day which necessary save
     */
    @MethodNoteBook(description = "set")
    protected void setDate(Integer year, Integer mount,Integer day) {
        Calendar currentCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        currentCalendar.set(year,mount+1,day);
        this.date = currentCalendar;
    }
}
