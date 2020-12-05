package com.service;

import com.exceptions.GetClientException;
import com.repository.ClientRepository;
import com.users.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Component
public class LoginService {

    private ClientRepository<Client> clientClientRepository;

    @Autowired
    public LoginService(ClientRepository<Client> clientClientRepository) {
        this.clientClientRepository = clientClientRepository;
    }

    public boolean login(String username, String password){
        Optional<Client> client = this.clientClientRepository.findByUsername(username);
        if (client.isPresent()){
            Client existingClient = client.get();

            if (existingClient.getPassword().equals(password)){
                System.out.println("[LOGIN SUCCESS] Login successful! Welcome " + username + "!\n");
                existingClient.setLogged(true);
                return true;
            }else {
                existingClient.setLogged(false);
                System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
                throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
            }
        }else {
            System.out.println("[INVALID] A user with username: " + username + " doesn't exist!\n");
            throw new GetClientException("[INVALID] A user with username: " + username + " doesn't exist!\n");
        }
    }
}
