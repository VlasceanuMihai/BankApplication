package com.requests;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.NonNull;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */

@Getter
@ToString
@EqualsAndHashCode
public class LoginRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;

    public LoginRequest(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }
}
