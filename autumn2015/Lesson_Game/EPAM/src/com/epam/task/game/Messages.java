package com.epam.task.game;

/**
 * Class enum for messages.
 *
 * @author Aliona Riabchenko
 * @version 1.00 17 Oct 2015
 */
public enum Messages {
    ERROR_VERY_BIG("The number is bigger than need"), ERROR_VERY_SMALL("The number is smaller than need"),
    OK("The number is right"), MESSAGE_NULL("The number can't be smaller than"), MESSAGE_OVER("The number can't be bigger than"),
    ENTER_MIN("Enter min: "), ENTER_MAX("Enter max: "), ENTER_AUTOMAT("Numbers were created automated "),
    WELLCOME("Enter number: "), GAME_OVER("Game over!"), ERROR("Error! Repeat, please"),TRY_AGAIN("Diapason is wrong! Try again..."),
    CONTINUOUS("Do you want continuous? (Y/N)");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    /**
     * The method get message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }
}
