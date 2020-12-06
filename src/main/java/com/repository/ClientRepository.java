package com.repository;

import com.exceptions.ClientAlreadyExistsException;
import com.exceptions.GetClientException;
import com.users.Client;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */

@Component
public class ClientRepository<T extends Client> implements CRUDInterface<T>, Serializable {

    private final List<T> clientList = new ArrayList<>();

    @Override
    public Optional<T> save(T client) {
        Optional<T> addedClient = this.findByUsername(client.getUsername());

        if (!addedClient.isPresent()) {
            client.generateId();
            this.clientList.add(client);
        }

        return addedClient;
    }

    @Override
    public boolean delete(String username) {
        return this.clientList.removeIf(client -> client.getUsername().equals(username));
    }

    @Override
    public Optional<T> exists(String username, String password) {
        return this.clientList.stream().filter(client -> (client.getUsername().equals(username)
                && client.getPassword().equals(password))).findFirst();
    }

    @Override
    public Optional<T> findByUsername(String username) {
        return this.clientList.stream().filter(currentClient -> currentClient.getUsername().equals(username)).findFirst();
    }

    @Override
    public Optional<T> findById(Long ownerId) {
        return this.clientList.stream().filter(client -> client.getUniqId().equals(ownerId)).findFirst();
    }

    @Override
    public Optional<T> findByClient(T client) {
        return this.clientList.stream().filter(currentClient -> currentClient.equals(client)).findFirst();
    }

    @Override
    public List<T> findAll() {
        System.out.println("Number of clients: " + this.clientList.size());
        return this.clientList;
    }

    @Override
    public Long countAll(){
        return (long) this.clientList.size();
    }
}
