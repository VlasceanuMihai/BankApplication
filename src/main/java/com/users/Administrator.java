package com.users;

import lombok.Getter;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */
public class Administrator {

    private static Long counter = 0L;
    @Getter
    private static Long numberOfClients = 0L;

    private Long id = 0L;
    private String username;
    private String password;

    public Administrator(String username, String password) {
        this.id = counter++;
        this.username = username;
        this.password = password;
    }
}
