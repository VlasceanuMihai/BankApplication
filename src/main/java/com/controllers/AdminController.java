package com.controllers;

import com.users.Client;
import com.service.AdminService;
import com.users.IndividualClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

/*
 * Expune functionalitatea pe care o poate apela un administrator.
 */

@Controller
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


//    @GetMapping(value = "/individualClientRegisterPage")
//    public String redirectToIndividualClientRegisterPage(){
//        return "redirect:individualClientRegister";
//    }

    @GetMapping(value = "/individualClientRegisterPage")
    public String individualClientRegisterPage(){
        System.out.println("Individual Register Page Requested");
        return "individualClientRegister";
    }

    @PostMapping(value = "/createIndividualClient")
    public String createIndividualClient(@Validated IndividualClient client, Model model) {
        model.addAttribute("ID", client.getUniqId());
        model.addAttribute("Username", client.getUsername());
        model.addAttribute("FirstName", client.getFirstName());
        model.addAttribute("LastName", client.getLastName());
        model.addAttribute("CNP", client.getCnp());
        model.addAttribute("Wage", client.getWage());
        System.out.println(client.getUsername());
        this.adminService.createIndividualClient(client);

        return "createIndividualClient";
    }

    @GetMapping(value = "/legalClientPage")
    public String redirectToCreateLegalClientPage(){
        return "legalClientRegister";
    }

    @PostMapping(value = "/createLegalClient")
    public String createLegalClient(String username,
                                    String password,
                                    String companyName,
                                    String cui,
                                    double costTransaction,
                                    double capital) {
        this.adminService.createLegalClient(username, password, companyName, cui, costTransaction, capital);

        return "legalClientRegister";
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
