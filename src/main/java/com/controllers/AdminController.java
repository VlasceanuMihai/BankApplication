package com.controllers;

import com.users.IndividualPerson;
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

    // Create individual person user
    public void createIndividualPersonUser(String username, String password, String firstName, String lastName,
        String cnp, double wage){
        this.adminService.createIndividualPersonUser(username, password, firstName, lastName, cnp, wage);
    }

    // Create legal person user
    public void createLegalPersonUser(String username, String password, String companyName, String cui,
                                      double costTransaction, double capital){
        this.adminService.createLegalPersonUser(username, password, companyName, cui, costTransaction, capital);
    }

    public List<IndividualPerson> getIndividualUsers(){
       return this.adminService.getIndividualUsers();
    }
}
