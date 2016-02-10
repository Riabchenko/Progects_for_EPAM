package com.intellect25.notebook;


import java.util.Calendar;
import java.util.TimeZone;

/**
 * The Day class generate date
 *
 * @version 1.00
 * @author Riabchenko Aliona
 */
public class Day {

    /** It stores current date as Calendar */
    private Calendar currentDate;

    /**
     * It's constructor without parameters
     */
    protected Day(){
        this(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
    }

    /**
     * It's constructor with entered Calendar
     *
     * @param currentDate currentDate
     */
    protected Day(Calendar currentDate){
        setCurrentDate(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH),
                currentDate.get(Calendar.DATE));
    }

    /**
     * It's constructor with entered yearNow,mountNow,dayNow
     *
     * @param yearNow entered parameter of year
     * @param mountNow entered parameter of month
     * @param dayNow entered parameter of day
     */
    protected Day(Integer yearNow, Integer mountNow,Integer dayNow){
        setCurrentDate(yearNow, mountNow, dayNow);
    }

    /**
     * get day of year
     *
     * @return amount of days from begin of year
     */
    @MethodNoteBook(description = "get")
    protected int getDayOfYear(){
        return currentDate.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * get current date
     *
     * @return currentDate
     */
    @MethodNoteBook(description = "get")
    protected Calendar getCurrentDate() {
        return currentDate;
    }

    /**
     * Set current date
     *
     * @param yearNow yearNow
     * @param mountNow mountNow
     * @param dayNow dayNow
     */
    @MethodNoteBook(description = "set")
    protected void setCurrentDate(Integer yearNow, Integer mountNow,Integer dayNow) {
        Calendar currentCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        currentCalendar.set(yearNow,mountNow,dayNow);
        this.currentDate = currentCalendar;
    }
}
