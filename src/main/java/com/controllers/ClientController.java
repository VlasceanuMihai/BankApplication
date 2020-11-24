package com.controllers;

import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */

/*
    - Afisaza toate conturile
    - Afisaza soldul unui cont
    - Transfera bani intr-un cont dupa IBAN
    - Transfera bani intre conturile proprii
    - Achita datorii intr-un cont de credit
    - Genereaza un raport al tuturor tranzactiilor dintr-un cont
 */

@Component
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
}
