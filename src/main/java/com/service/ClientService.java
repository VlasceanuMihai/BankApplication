package com.service;

import com.repository.ClientRepository;
import com.users.Client;

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

public class ClientService {

    private ClientRepository<Client> clientRepository;

    public ClientService(ClientRepository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }


}
