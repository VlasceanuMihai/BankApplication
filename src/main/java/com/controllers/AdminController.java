package com.controllers;

import com.users.Client;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

// Expune functionalitatea pe care o poate apela un administrator.

@Controller
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Create individual client
    @PostMapping(value = "/createIndividualClient")
    public void createIndividualClient(Client client, Model model) {
//        this.adminService.createIndividualClient(username, password, firstName, lastName, cnp, wage);
//        this.adminService.createIndividualClient(username, password, firstName, lastName, cnp, wage);
    }

    // Create legal client
    public void createLegalClient(String username,
                                  String password,
                                  String companyName,
                                  String cui,
                                  double costTransaction,
                                  double capital) {
        this.adminService.createLegalClient(username, password, companyName, cui, costTransaction, capital);
    }

    // Remove client
    public void removeClient(String username) {
        this.adminService.removeClient(username);
    }

    // Get client list: get all clients (Individuals + Legals)
    public List<Client> getClientList() {
        return this.adminService.getClientList();
    }

    // Create debit bank account
    public void createDebitBankAccount(String username, double amount) {
        this.adminService.createDebitBankAccount(username, amount);
    }

    // Create debit bank account
    public void createCreditBankAccount(String username, double amount) {
        this.adminService.createCreditBankAccount(username, amount);
    }
}
