package com.service;

import com.exceptions.GetClientException;
import com.repository.ClientRepository;
import com.requests.LoginRequest;
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

    public boolean login(LoginRequest loginRequest){
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<Client> client = this.clientClientRepository.exists(username, password);
        if (client.isPresent()){
            System.out.println("[LOGIN SUCCESS] Login successful! Welcome " + username + "!\n");
            client.get().setLogged(true);
            return true;
        }else {
            System.out.println("[INVALID USER] Invalid username or password!\n");
            throw new GetClientException("[INVALID USER] Invalid username or password!\n");
        }
    }
}
