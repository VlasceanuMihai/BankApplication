package com.controllers;

import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */

/*
 * Expune functionalitatea pe care o poate apela un client de tipul persoana fizica/ persoana juridica
 */

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
}
