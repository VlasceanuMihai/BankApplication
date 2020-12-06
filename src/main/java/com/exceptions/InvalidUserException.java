package com.exceptions;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */
public class InvalidUserException extends RuntimeException{

    public InvalidUserException() {
        super();
    }

    public InvalidUserException(String message) {
        super(message);
    }
}
