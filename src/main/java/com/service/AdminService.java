package com.service;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import com.enums.BankAccountType;
import com.exceptions.ClientAlreadyExistsException;
import com.exceptions.InvalidClientException;
import com.repository.client.ClientRepository;
import com.users.Client;
import com.users.IndividualClient;
import com.users.LegalClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private ClientRepository<Client> clientRepository;
    private AccountService accountService;

    @Autowired
    public AdminService(ClientRepository<Client> clientRepository, AccountService accountService) {
        this.clientRepository = clientRepository;
        this.accountService = accountService;
    }

    public void createIndividualClient(IndividualClient individualClient) {
        log.info(String.valueOf(individualClient));

        boolean isSaved = this.clientRepository.save(individualClient);
        if (isSaved) {
            log.info("[REGISTER SUCCESS] User with username: " + individualClient.getUsername() + " added successfully.");
            return;
        }

        throw new ClientAlreadyExistsException("[CLIENT ALREADY EXISTS] A user with this username: " + individualClient.getUsername() + " already exists!");
    }

    public void createLegalClient(LegalClient legalClient) {
        log.info(String.valueOf(legalClient));

        boolean isSaved = this.clientRepository.save(legalClient);
        if (isSaved) {
            log.info("[REGISTER SUCCESS] User with username: " + legalClient.getUsername() + " added successfully.");
            return;
        }

        throw new ClientAlreadyExistsException("[CLIENT ALREADY EXISTS] A user with this username: " + legalClient.getUsername() + " already exists!");
    }

    public void deleteClient(String username) {
        boolean isDeleted = this.clientRepository.delete(username);
        if (isDeleted) {
            this.clientRepository.findByUsername(username).ifPresent(Client::decrementNumberOfClients);
            log.info("[DELETE SUCCESS] User with username: " + username + " has been removed!");
            return;
        } else {
            throw new InvalidClientException("[NON-EXISTENT CLIENT] A user with username: " + username + " doesn't exist!");
        }
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    // Create debit bank account based on username & amount
    public void createDebitBankAccount(String username, double amount) {
        Optional<Client> client = this.clientRepository.findByUsername(username);
        if (client.isPresent()) {
            Client existingClient = client.get();
            existingClient.getDebitList().add(new DebitBankAccountDTO(BankAccountType.DEBIT, existingClient.getId(), amount));
            log.info("[DEBIT ACCOUNT] Debit bank account created for user " + username + "!\n" + existingClient.getDebitList() + "\n");
        } else {
            throw new InvalidClientException("[NON-EXISTENT CLIENT] A user with username: " + username + " doesn't exist!");
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

            existingClient.getCreditList().add(new CreditBankAccountDTO(BankAccountType.CREDIT, existingClient.getId(), amount, limitAmount));
            log.info("[CREDIT ACCOUNT] Credit bank account created for user " + username + "!\n" + existingClient.getCreditList() + "\n");
        }else {
            throw new InvalidClientException("[NON-EXISTENT CLIENT] A user with username: " + username + " doesn't exist!\n");
        }
    }
}
