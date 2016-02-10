package com.epam.task;

import com.epam.task.game.Factory;

/**
 * Class creates a game.
 *
 * @author Aliona Riabchenko
 * @version 1.01 19 Oct 2015
 */
public class MainGame {

    public static void main(String[] args) {
        Factory.createNewGame().startGame();
    }
}
