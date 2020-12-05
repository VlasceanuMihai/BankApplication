package com.controllers;

import com.users.Client;
import com.service.AdminService;
import com.users.IndividualClient;
import com.users.LegalClient;
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


    @GetMapping(value = "/individualClientRegisterPage")
    public String individualClientRegisterPage() {
        System.out.println("Individual Register Page Requested");
        return "individualClientRegister";
    }

    @PostMapping(value = "/createIndividualClient")
    public String createIndividualClient(@Validated IndividualClient client, Model model) {
        this.adminService.createIndividualClient(client);

        model.addAttribute("ID", client.getUniqId());
        model.addAttribute("Username", client.getUsername());
        model.addAttribute("FirstName", client.getFirstName());
        model.addAttribute("LastName", client.getLastName());
        model.addAttribute("CNP", client.getCnp());
        model.addAttribute("Wage", client.getWage());

        return "createIndividualClient";
    }

    @GetMapping(value = "/legalClientRegisterPage")
    public String legalClientRegisterPage() {
        System.out.println("Legal Register Page Requested");
        return "legalClientRegister";
    }

    @PostMapping(value = "/createLegalClient")
    public String createLegalClient(LegalClient client, Model model) {
        this.adminService.createLegalClient(client);

        model.addAttribute("ID", client.getUniqId());
        model.addAttribute("Username", client.getUsername());
        model.addAttribute("CompanyName", client.getCompanyName());
        model.addAttribute("CUI", client.getCui());
        model.addAttribute("CostTransaction", client.getCostTransaction());
        model.addAttribute("Capital", client.getCapital());

        return "createLegalClient";
    }

    public void deleteClient(String username) {
        this.adminService.deleteClient(username);
    }

    // Get client list: get all clients (Individuals + Legals)
    public List<Client> getClientsList() {
        return this.adminService.getClientsList();
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
