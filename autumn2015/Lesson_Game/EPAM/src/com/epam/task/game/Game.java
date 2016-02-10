package com.epam.task.game;

import java.util.Map;

/**
 * Interface for a game.
 *
 * @author Aliona Riabchenko
 * @version 1.01 19 Oct 2015
 */
public interface Game {

    /**
     * The method choose a number from the diapason between
     * min and max numbers.
     *
     * @param min number
     * @param max number
     * @return rand number
     */
    int rand(int min, int max);

    /**
     * The method automated choose a number from the diapason between
     * 0 and 100 numbers.
     *
     * @return rand number
     */
    int rand();

    /**
     * The method checks input number
     *
     * @param number entered number
     * @return object of Message
     */
    Messages check(int number);

    /**
     * The method get list
     *
     * @return Map
     */
    Map<Integer,String> getList();

    /**
     * The method set data into list
     *
     * @param number entered number
     * @param message object of Message
     */
    void setList(Integer number, Messages message);

    /**
     * The method get a max number
     *
     * @return max
     */
    int getMax();

    /**
     * The method get a min number
     *
     * @return min
     */
    int getMin();

    /**
     * The method set a min number
     *
     * @param min min border
     */
    void setMin(int min);

    /**
     * The method set a max number
     *
     * @param max max border
     */
    void setMax(int max);


}
