package com.controllers;

import com.service.LoginService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@Setter
@Component
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean login(String username, String password) {
        return this.loginService.login(username, password);
    }
}
