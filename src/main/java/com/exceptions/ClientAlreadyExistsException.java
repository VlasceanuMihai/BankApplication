package com.exceptions;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/5/2020
 */
public class ClientAlreadyExistsException extends RuntimeException{

    public ClientAlreadyExistsException() {
        super();
    }

    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}
