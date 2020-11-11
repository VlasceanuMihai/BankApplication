package com.controllers;

import com.users.Client;
import com.service.AdminService;

import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

// Expune functionalitatea pe care o poate apela un administrator.

public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Create individual client
    public void createIndividualClient(String username, String password, String firstName, String lastName,
        String cnp, double wage){
        this.adminService.createIndividualClient(username, password, firstName, lastName, cnp, wage);
    }

    // Create legal client
    public void createLegalClient(String username, String password, String companyName, String cui,
                                      double costTransaction, double capital){
        this.adminService.createLegalClient(username, password, companyName, cui, costTransaction, capital);
    }

    // Remove client
    public void removeClient(String username){
        this.adminService.removeClient(username);
    }

    public List<Client> getClientList(){
       return this.adminService.getClientList();
    }
}
