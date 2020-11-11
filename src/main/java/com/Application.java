package com;

import com.controllers.AdminController;
import com.controllers.LoginController;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */
public class Application {
    private static ApplicationContext APPLICATION_CONTEXT;

    @BeforeClass
    public static void setupAppContext(){
        APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testCreateNewUser(){
        AdminController adminController = APPLICATION_CONTEXT.getBean("adminController", AdminController.class);
        LoginController loginController = APPLICATION_CONTEXT.getBean("loginController", LoginController.class);

        // Create/remove clients
        adminController.createIndividualClient("mihai", "1234", "Mihai",
                "Vlasceanu", "1960122440022", 3700);

        adminController.createIndividualClient("mihai", "1234", "wdaw",
                "esgfswe", "1960122440022", 6700);

        adminController.createIndividualClient("vlasceanu", "123456", "Vls",
                "Vls", "1960122357222", 4000);

        adminController.createLegalClient("mihai", "abcde", "Mihai SRL", "123456",
                10, 2000);

        adminController.removeClient("mihai");

        // Login
        loginController.login("vlasceanu", "123456");
        loginController.login("mihai", "123456");
    }
}
