package com;

import com.controllers.AdminController;
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

        adminController.createIndividualPersonUser("mihai", "1234", "Mihai",
                "Vlasceanu", "1960122440022", 3700);

        System.out.println(adminController.getIndividualUsers());

    }
}
