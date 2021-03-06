package com.repository;

import com.exceptions.GetClientException;
import com.users.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */
public class ClientRepository<T extends Client>  implements Serializable {

    private final List<T> clientList = new ArrayList<>();


    public void addClient(T client){
        for (T c : this.clientList){
            if (c.getUsername().equals(client.getUsername())){
                System.out.println("A user with this username: " + client.getUsername() + " already exists!\n");
                return;
            }
        }

        this.clientList.add(client);
        client.generateId();
        System.out.println("[REGISTER SUCCESS] User with username: " + client.getUsername() + " added successfully.");
        System.out.println(this.getClientList() + "\n");
    }

    public void removeClient(String username){
        boolean b = this.clientList.removeIf(client -> client.getUsername().equals(username));
        if (b){
            System.out.println("[DELETE SUCCESS] User with username: " + username + " has been removed!");
            System.out.println(this.getClientList() + "\n");
            return;
        }
        System.out.println("[ERROR] The user with username: " + username + " doesn't exist!");
    }

    public T findClientByUsername(String username){
        for (T user : this.clientList){
            if (user.getUsername().equals(username)){
                return user;
            }
        }

        throw new GetClientException("[ERROR] The user with username: " + username + " doesn't exist!");
    }

    public T getClient(String username){
        for (T  client : this.clientList){
            if (client.getUsername().equals(username)){
                return client;
            }
        }

        throw new GetClientException("[ERROR] The user with username: " + username + " doesn't exist!");
    }

    public List<T> getClientList(){
        System.out.println("Number of clients: " + this.clientList.size());
        return this.clientList;
    }




    //    public void updateFirstName(T client, String firstName){
//        if (this.clientList.contains(client))
//        for (Client clientUser : clientList){
//            if (this.clientList.contains(client)){
//        }
//            this.clientList.setFirstName(firstName);
//            System.out.println("User has been updated!");
//        }else {
//            System.out.println("The user doesn't exist!");
//        }
//    }
//
//    public void updateLastName(String username, String lastName){
//        if (this.map.containsKey(username)){
//            this.map.get(username).setLastName(lastName);
//            System.out.println("User has been updated!");
//        }else {
//            System.out.println("The user doesn't exist!");
//        }
//    }

//    public List<T> getIndividualClientList(){
//
//    }
}
