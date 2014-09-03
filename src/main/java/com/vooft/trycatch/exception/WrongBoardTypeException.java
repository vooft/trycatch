package com.vooft.trycatch.exception;

/**
 * Created by vooft on 01.09.14.
 */
public class WrongBoardTypeException extends RuntimeException {
    public WrongBoardTypeException() {
        super("Board type is wrong");
    }
}
