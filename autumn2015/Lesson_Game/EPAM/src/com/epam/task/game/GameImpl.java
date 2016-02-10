package com.epam.task.game;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Class for a game.
 *
 * @author Aliona Riabchenko
 * @version 1.01 19 Oct 2015
 */
public class GameImpl implements Game {
    private int RAND_MAX = 100;
    private int RAND_MIN = 0;
    private int rand;
    private int min;
    private int max;
    private HashMap<Integer, String> list;

    public GameImpl() {
        list = new LinkedHashMap<Integer, String>();
    }

    @Override
    public int rand(int min, int max) {
        if (min > max) {
            this.min = max;
            this.max = min;
        } else {
            this.min = min;
            this.max = max;
        }
        if (this.max - this.min >= 2) {
            Random objectRandom = new Random();
            do {
                rand = this.min + (int) objectRandom.nextInt(this.max - this.min + 1);
            } while (rand == this.max || rand == this.min);
        } else {
            rand = -1;
        }

        return rand;
    }

    @Override
    public int rand() {
        this.min = RAND_MIN;
        this.max = RAND_MAX;
        return rand(min, max);
    }

    @Override
    public Messages check(int number) {
        if (number > rand) {
            list.put(number, Messages.ERROR_VERY_BIG.getMessage());
            return Messages.ERROR_VERY_BIG;
        } else if (number < rand) {
            list.put(number, Messages.ERROR_VERY_BIG.getMessage());
            return Messages.ERROR_VERY_SMALL;
        } else if (number == rand) {
            list.put(number, Messages.OK.getMessage());
            return Messages.OK;
        }
        return Messages.OK;
    }

    @Override
    public Map<Integer, String> getList() {
        return list;
    }

    @Override
    public void setList(Integer number, Messages message) {
        if (message == Messages.MESSAGE_NULL || message == Messages.MESSAGE_OVER) {
            list.put(number, message.getMessage() + " " + number);
        } else {
            list.put(number, message.getMessage());
        }
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public void setMax(int max) {
        this.max = max;
    }


}
