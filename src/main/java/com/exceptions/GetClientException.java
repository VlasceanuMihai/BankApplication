package com.exceptions;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */
public class GetClientException extends RuntimeException{

    public GetClientException() {
        super();
    }

    public GetClientException(String message) {
        super(message);
    }
}
