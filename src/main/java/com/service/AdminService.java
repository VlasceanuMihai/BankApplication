package com.service;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import com.exceptions.ClientAlreadyExistsException;
import com.exceptions.GetClientException;
import com.repository.ClientRepository;
import com.users.Client;
import com.users.IndividualClient;
import com.users.LegalClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

/*
 * Are rolul de a executa logica accesata de admin:
 * - creaza un nou utilizator (persoana fizica sau juridica)
 * - creaza un cont de debit pentru un utilizator dupa username
 * - creaza un cont de credit pentru utilizator dupa username setand o limita pentru cardul de credit
 */

@Service
@Slf4j
public class AdminService {

    private final ClientRepository<Client> clientRepository;

    @Autowired
    public AdminService(ClientRepository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void createIndividualClient(IndividualClient individualClient) {
        log.info(String.valueOf(individualClient));
        System.out.println(individualClient);

        Optional<Client> client = this.clientRepository.save(individualClient);
        if (client.isPresent()) {
            System.out.println("[REGISTER SUCCESS] User with username: " + individualClient.getUsername() + " added successfully.");
            System.out.println(this.getClientsList() + "\n");
        } else {
            System.out.println("A user with this username: " + individualClient.getUsername() + " already exists!\n");
            throw new ClientAlreadyExistsException("A user with this username: " + individualClient.getUsername() + " already exists!");
        }
    }

    public void createLegalClient(LegalClient legalClient) {
        log.info(String.valueOf(legalClient));
        System.out.println(legalClient);

        Optional<Client> client = this.clientRepository.save(legalClient);
        if (client.isPresent()) {
            System.out.println("[REGISTER SUCCESS] User with username: " + legalClient.getUsername() + " added successfully.");
            System.out.println(this.getClientsList() + "\n");
        } else {
            System.out.println("A user with this username: " + legalClient.getUsername() + " already exists!\n");
            throw new ClientAlreadyExistsException("A user with this username: " + legalClient.getUsername() + " already exists!");
        }
    }

    public boolean deleteClient(String username) {
        boolean isDeleted = this.clientRepository.delete(username);
        if (isDeleted) {
            System.out.println("[DELETE SUCCESS] User with username: " + username + " has been removed!");
            System.out.println(this.getClientsList() + "\n");
            return true;
        } else {
            System.out.println("[ERROR] The user with username: " + username + " doesn't exist!");
            throw new GetClientException("[ERROR] The user with username: " + username + " doesn't exist!");
        }
    }

    public List<Client> getClientsList() {
        return this.clientRepository.findAll();
    }

    // Create debit bank account based on username & amount
    public void createDebitBankAccount(String username, double amount) {
        Optional<Client> client = this.clientRepository.findByUsername(username);
        if (client.isPresent()) {
            Client existingClient = client.get();
            existingClient.getDebitList().add(new DebitBankAccountDTO(existingClient.getUniqId(), amount));
            System.out.println("[DEBIT ACCOUNT] Debit bank account created for user " + username + "!\n" + existingClient.getDebitList() + "\n");
        } else {
            System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
            throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
        }
    }

    // Create credit bank account based on username & amount
    public void createCreditBankAccount(String username, double amount) {
        Optional<Client> client = this.clientRepository.findByUsername(username);
        if (client.isPresent()){
            Client existingClient = client.get();

            double limitAmount = 0;
            if (existingClient instanceof IndividualClient) {
                limitAmount = ((IndividualClient) existingClient).getWage();
            } else if (existingClient instanceof LegalClient) {
                limitAmount = ((LegalClient) existingClient).getCapital() * (10.0 / 100);
            }

            existingClient.getCreditList().add(new CreditBankAccountDTO(existingClient.getUniqId(), amount, limitAmount));
            System.out.println("[CREDIT ACCOUNT] Credit bank account created for user " + username + "!\n" + existingClient.getCreditList() + "\n");
        }else {
            System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
            throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
        }
    }
}
