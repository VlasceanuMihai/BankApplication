package com.service;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import com.exceptions.GetClientException;
import com.repository.ClientRepository;
import com.users.Client;
import com.users.IndividualClient;
import com.users.LegalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class AdminService {

    private final ClientRepository<Client> clientRepository;

    @Autowired
    public AdminService(ClientRepository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void createIndividualClient(IndividualClient client) {
        System.out.println(client);
        this.clientRepository.createClient(client);
    }

    // Create legal client
    public void createLegalClient(String username,
                                  String password,
                                  String companyName,
                                  String cui,
                                  double costTransaction,
                                  double capital) {
        this.clientRepository.createClient(new LegalClient(username, password, companyName, cui, costTransaction, capital));
    }

    // Remove client  based on username
    public void removeClient(String username) throws GetClientException{
        try {
            this.clientRepository.findClientByUsername(username).decrementNumberOfClients();
        } catch (GetClientException e) {
            System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
            throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
        }

        this.clientRepository.removeClient(username);
    }

    // Get the client list
    public List<Client> getClientList() {
        return this.clientRepository.getClientList();
    }

    // Create debit bank account based on username & amount
    public void createDebitBankAccount(String username, double amount) {
        try {
            Client client = this.clientRepository.findClientByUsername(username);
            client.getDebitList().add(new DebitBankAccountDTO(client.getUniqId(), amount));
            System.out.println("[DEBIT ACCOUNT] Debit bank account created for user " + username + "!\n" + client.getDebitList() + "\n");
        } catch (GetClientException e) {
            System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
            throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
        }
    }

    // Create credit bank account based on username & amount
    public void createCreditBankAccount(String username, double amount) {
        try {
            Client client = this.clientRepository.findClientByUsername(username);
            double limitAmount = 0;
            if (client instanceof IndividualClient) {
                limitAmount = ((IndividualClient) client).getWage();
            } else if (client instanceof LegalClient) {
                limitAmount = ((LegalClient) client).getCapital() * (10.0 / 100);
            }

            client.getCreditList().add(new CreditBankAccountDTO(client.getUniqId(), amount, limitAmount));
            System.out.println("[CREDIT ACCOUNT] Credit bank account created for user " + username + "!\n" + client.getCreditList() + "\n");
        } catch (GetClientException e) {
            System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
            throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
        }

    }
}
