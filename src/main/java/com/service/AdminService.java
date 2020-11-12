package com.service;

import com.exceptions.GetClientException;
import com.repository.ClientRepository;
import com.users.Client;
import com.users.IndividualClient;
import com.users.LegalClient;

import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

/*
Are rolul de a executa logica accesata de admin. Functionalitati implementate:
- creaza un nou utilizator (persoana fizica sau juridica)
- creaza un cont de debit pentru un utilizator dupa username
- creaza un cont de credit pentru utilizator dupa username setand o limita pentru cardul de credit
(limita de maxim 100% din salariul clientului sau 10% din capitalul unei firme).
 */

public class AdminService {

    private final ClientRepository<Client> clientRepository;

    public AdminService(ClientRepository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void createIndividualClient(String username,
                                       String password,
                                       String fistName,
                                       String lastName,
                                       String cnp,
                                       double wage){
        this.clientRepository.addClient(new IndividualClient(username, password, fistName, lastName, cnp, wage));
    }

    public void createLegalClient(String username,
                                  String password,
                                  String companyName,
                                  String cui,
                                  double costTransaction,
                                  double capital){
        this.clientRepository.addClient(new LegalClient(username, password, companyName, cui, costTransaction, capital));
    }

    public void removeClient(String username){
        this.clientRepository.removeClient(username);
        try {
            this.clientRepository.findClientByUsername(username).decrementNumberOfClients();
        }catch (GetClientException e){
            System.out.println("A user with username: " + username + " doesn't exist!\n");
        }
    }

    public List<Client> getClientList(){
        return this.clientRepository.getClientList();
    }

    public void createDebitBankAccount(){

    }
}
