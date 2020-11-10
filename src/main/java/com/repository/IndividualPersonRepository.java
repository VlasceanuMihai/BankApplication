package com.repository;

import com.model.IndividualPerson;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */
public class IndividualPersonRepository {

    private Map<String, IndividualPerson> map = new HashMap<>();

    public void addUser(String username, IndividualPerson user){
        if (!this.map.containsKey(username)) {
            this.map.put(username, user);
            System.out.println("User added successfully.");
        }else {
            System.out.println("A user with this username already exists!");
        }
    }

    public void removeUser(String username){
        if (this.map.containsKey(username)) {
            this.map.remove(username);
            System.out.println("The user has been deleted!");
        }else {
            System.out.println("The user doesn't exist!");
        }
    }

    public void updateFirstName(String username, String firstName){
        if (this.map.containsKey(username)){
            this.map.get(username).setFirstName(firstName);
            System.out.println("User has been updated!");
        }else {
            System.out.println("The user doesn't exist!");
        }
    }

    public void updateLastName(String username, String lastName){
        if (this.map.containsKey(username)){
            this.map.get(username).setLastName(lastName);
            System.out.println("User has been updated!");
        }else {
            System.out.println("The user doesn't exist!");
        }
    }

    public void updateFirstName(String username, double wage){
        if (this.map.containsKey(username)){
            this.map.get(username).setWage(wage);
            System.out.println("User has been updated!");
        }
        System.out.println("The user doesn't exist!");
    }

    public IndividualPerson getIndividualUser(String username){
        if (this.map.containsKey(username)){
            return this.map.get(username);
        }
        return null;
    }

    public List<IndividualPerson> getIndividualUsers(){
        return new ArrayList<>(this.map.values());
    }
}
