package com;

import com.controllers.AdminController;
import com.controllers.LoginController;
import com.repository.ClientRepository;
import com.users.Client;
import lombok.Getter;
import lombok.Setter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */
public class Application {
    private static ApplicationContext APPLICATION_CONTEXT;
    private static final String file = "src/save.dat";

//    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private static ClientRepository<Client> clientRepository;


    @BeforeClass
    public static void setupAppContext() throws IOException, ClassNotFoundException {
        APPLICATION_CONTEXT = new ClassPathXmlApplicationContext("applicationContext.xml");
//        if (restoreFile() != null){
//            clientRepository = restoreFile();
//        }
    }

    @Test
    public void testCreateNewUser() {
        AdminController adminController = APPLICATION_CONTEXT.getBean("adminController", AdminController.class);
        LoginController loginController = APPLICATION_CONTEXT.getBean("loginController", LoginController.class);


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
        loginController.login("andrei", "123asd");
    }


//    public static void saveFile() throws IOException {
//        try(ObjectOutputStream binaryFileOut = new ObjectOutputStream(
//                new BufferedOutputStream(new FileOutputStream(file)))){
//            binaryFileOut.writeObject(clientRepository);
//        }
//    }
//
//    public static ClientRepository<Client> restoreFile()throws IOException, ClassNotFoundException{
//        ClientRepository<Client> restoreClientRepository = null;
//
//        try(ObjectInputStream binaryFileIn = new ObjectInputStream(
//                new BufferedInputStream(new FileInputStream(file)))){
//            restoreClientRepository = (ClientRepository<Client>) binaryFileIn.readObject();
//        } catch (EOFException e) {
//            System.out.println("Empty file!");
//        }
//            return restoreClientRepository;
//    }
//
//    // Reset/Delete data from 'save.dat' file
//    private static void reset()throws IOException{
//        try (ObjectOutputStream reset = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
//            reset.reset();
//        }
//    }
}
