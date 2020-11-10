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

    public void login(String username, String password){
        this.loginService.login(username, password);
    }
}
