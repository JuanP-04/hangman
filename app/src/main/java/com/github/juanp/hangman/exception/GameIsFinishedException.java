package com.github.juanp.hangman.exception;

public class GameIsFinishedException extends RuntimeException {

    public GameIsFinishedException(String message) {
        super(message);
    }

}
