package com.epam.task.game;

import java.util.Map;

/**
 * Class for a user.
 *
 * @author Aliona Riabchenko
 * @version 1.01 19 Oct 2015
 */
public class ReceptionImpl implements Reception {
    private int WRONG_IN = -1;
    private int EXIT = -2;
    private int YES = -3;
    private int NO = -4;
    private int rand;
    private Game game;

    @Override
    public void startGame() {
        int min = 0;
        int max = 0;
        int enteredNumber = 0;
        game = new GameImpl();

        Writer.message(Messages.ENTER_MIN.getMessage());
        min = Reader.start();

        /*
        * if min is wrong {
        * borders create automatically
        * } else {
        *  if min < 0 than min border creates as 0
        *  if max is wrong {
        *   borders create automatically
        *   } else {
        *   random number is created
        *   if random number couldn't create than message 'Try again' is displaying
        *  }
        */
        if (min == WRONG_IN) {
            rand = game.rand();
            Writer.message(Messages.ENTER_AUTOMAT.getMessage());
        } else {
            if (min < 0) {
                Writer.message(Messages.MESSAGE_NULL.getMessage() + " 0. So min = 0");
            }

            Writer.message(Messages.ENTER_MAX.getMessage());
            max = Reader.start();

            if (max == WRONG_IN) {
                rand = game.rand();
                Writer.message(Messages.ENTER_AUTOMAT.getMessage());
            } else {
                if (max < 0) {
                    Writer.message(Messages.MESSAGE_NULL.getMessage() + " 0. So min = 0");
                }
                rand = game.rand(min, max);

                if (rand == WRONG_IN) {
                    Writer.message(Messages.TRY_AGAIN.getMessage());
                    startGame();
                }
            }
        }

        /* if random number isn't wrong suggest input number */
        if (rand != WRONG_IN) {
            Writer.message(Messages.WELLCOME.getMessage());
            Writer.message("Choose from " + game.getMin() + " to " + game.getMax());

            /* Start method enterNumber which runs while user enters right number */
            while (enterNumber()) ;

            Writer.message(Messages.GAME_OVER.getMessage());
            showReport();
        }
        exit();
    }

    /*
     * The method is given opportunity to users enter number
     */
    private boolean enterNumber() {
       int number = Reader.start();
        if (number == WRONG_IN) {
            Writer.message(Messages.ERROR.getMessage());
            enterNumber();
        } else if (number == EXIT) {
            return false;
        } else if (number >= game.getMin() && number <= game.getMax()) {
            Messages res = game.check(number);

            if (res == Messages.ERROR_VERY_SMALL || res == Messages.ERROR_VERY_BIG) {
                newMinMax(res, number);
                doing(number, res);
            }
        } else if (number < game.getMin()) {
            doing(number, Messages.MESSAGE_NULL);
        } else if (number > game.getMax()) {
            doing(number, Messages.MESSAGE_OVER);
        }
        return false;
    }

    /**
     * This method inputs data into list, outputs messages and
     * invokes method enterNumber
     *
     * @param number
     * @param mes
     */
    private void doing(int number, Messages mes){
        game.setList(number, mes);
        Writer.message("Choose from " + game.getMin() + " to " + game.getMax());
        enterNumber();
    }

    /**
     * This method changes min and max in the game
     *
     * @param res
     * @param number
     */
    private void newMinMax(Messages res, int number) {
        if (res == Messages.ERROR_VERY_SMALL) {
            game.setMin(number);
            Writer.message(Messages.ERROR_VERY_SMALL.getMessage() + ". New min: " + game.getMin());
        } else if (res == Messages.ERROR_VERY_BIG) {
            game.setMax(number);
            Writer.message(Messages.ERROR_VERY_BIG.getMessage() + ". New max: " + game.getMax());
        }
    }

    /**
     * This method shows reports continuous a game
     */
    private void showReport() {
        Writer.message("Statistics:");

        for (Map.Entry<Integer, String> el : game.getList().entrySet()) { //or  list.forEach((k,v) -> say(k,v));
            Writer.say(el.getKey(), el.getValue());
        }
    }

    /**
     * This method offers continuous a game
     */
    private void exit() {
        Writer.message(Messages.CONTINUOUS.getMessage());

        int continuous = Reader.start();

        if (continuous == YES) {
            startGame();
        } else if (continuous == NO) {
            //noting
        } else {
            exit();
        }
    }


}
