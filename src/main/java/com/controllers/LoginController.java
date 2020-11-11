package com.controllers;

import com.service.LoginService;
import lombok.Getter;
import lombok.Setter;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@Setter
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean login(String username, String password){
        return this.loginService.login(username, password);
    }
}
