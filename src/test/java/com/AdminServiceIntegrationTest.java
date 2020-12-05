package com;

import com.config.Config;
import com.service.AdminService;
import com.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/24/2020
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class AdminServiceIntegrationTest {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LoginService loginService;

//    @Test
//    public void createIndividualClient_(){
//
//    }

//    @Test
//    public void testCreateNewUser() {
//
//        // Create/remove clients
//        adminService.createindividualclient("mihai", "1234", "Mihai",
//                "Vlasceanu", "1960122440022", 3700);
//        adminService.createDebitBankAccount("mihai", 19000);
//        adminService.createCreditBankAccount("mihai", 2500);
//
//        adminService.createindividualclient("mihai", "1234", "wdaw",
//                "esgfswe", "1960122440022", 6700);
//
//        adminService.createindividualclient("vlasceanu", "123456", "Vls",
//                "Vls", "1960122357222", 4000);
//        adminService.createDebitBankAccount("mihai", 4000);
//        adminService.createCreditBankAccount("mihai", 1000);
//        adminService.createDebitBankAccount("vlasceanu", 1200);
//        adminService.createCreditBankAccount("vlasceanu", 250);
//
//        adminService.createLegalClient("mihai", "abcde", "Mihai SRL", "123456",
//                10, 2000);
//
//        adminService.createLegalClient("andrei", "123asd", "Andrei SRL", "6543",
//                23, 4323);
//
//        adminService.createindividualclient("teo", "123", "Teo",
//                "Teo", "4562352", 2540);
//
//        // Login
//        loginService.login("vlasceanu", "123456");
//        loginService.login("andrei", "123456");
//        loginService.login("andrei", "123asd");
//        adminService.removeClient("andrei");
////        loginController.login("andrei", "123asd");
//    }
}
