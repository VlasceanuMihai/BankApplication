package com;

import com.config.Config;
import com.controllers.AdminController;
import com.controllers.LoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/24/2020
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class AdminServiceIntegrationTest {

    @Autowired
    private AdminController adminController;

    @Autowired
    private LoginController loginController;

//    @Test
//    public void createIndividualClient_(){
//
//    }

    @Test
    public void testCreateNewUser() {

        // Create/remove clients
        adminController.createIndividualClient("mihai", "1234", "Mihai",
                "Vlasceanu", "1960122440022", 3700);
        adminController.createDebitBankAccount("mihai", 19000);
        adminController.createCreditBankAccount("mihai", 2500);

        adminController.createIndividualClient("mihai", "1234", "wdaw",
                "esgfswe", "1960122440022", 6700);

        adminController.createIndividualClient("vlasceanu", "123456", "Vls",
                "Vls", "1960122357222", 4000);
        adminController.createDebitBankAccount("mihai", 4000);
        adminController.createCreditBankAccount("mihai", 1000);
        adminController.createDebitBankAccount("vlasceanu", 1200);
        adminController.createCreditBankAccount("vlasceanu", 250);

        adminController.createLegalClient("mihai", "abcde", "Mihai SRL", "123456",
                10, 2000);

        adminController.createLegalClient("andrei", "123asd", "Andrei SRL", "6543",
                23, 4323);

        adminController.createIndividualClient("teo", "123", "Teo",
                "Teo", "4562352", 2540);

        // Login
        loginController.login("vlasceanu", "123456");
        loginController.login("andrei", "123456");
        loginController.login("andrei", "123asd");
        adminController.removeClient("andrei");
//        loginController.login("andrei", "123asd");
    }
}
