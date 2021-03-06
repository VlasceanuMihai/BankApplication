package com.service;

import com.exceptions.GetClientException;
import com.repository.ClientRepository;
import com.users.Client;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */
public class LoginService {

    private ClientRepository<Client> clientClientRepository;

    public LoginService(ClientRepository<Client> clientClientRepository) {
        this.clientClientRepository = clientClientRepository;
    }

    public boolean login(String username, String password){
        boolean doPasswordsMatch = false;

        try{
            Client client = this.clientClientRepository.findClientByUsername(username);
            if (password.equals(client.getPassword())){
                System.out.println("[LOGIN SUCCESS] Login successful! Welcome " + username + "!\n");
                doPasswordsMatch = true;
                client.setLogged(true);
            }else {
                System.out.println("[INVALID PASSWORD] Invalid password for user " + username + "!\n");
                client.setLogged(false);
            }
        }catch (GetClientException e){
            System.out.println("[ERROR] The user with username: " + username + " doesn't exist!\n");
        }

        return doPasswordsMatch;
    }
}
