package com.exceptions;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */
public class InvalidClientException extends RuntimeException{

    public InvalidClientException() {
        super();
    }

    public InvalidClientException(String message) {
        super(message);
    }
}
