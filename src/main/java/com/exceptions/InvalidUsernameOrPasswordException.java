package com.exceptions;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */
public class InvalidUsernameOrPasswordException extends RuntimeException{

    public InvalidUsernameOrPasswordException() {
            super();
        }

    public InvalidUsernameOrPasswordException(String message) {
            super(message);
        }
}
