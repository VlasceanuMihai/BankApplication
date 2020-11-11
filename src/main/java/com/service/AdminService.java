package com.service;

import com.users.IndividualPerson;
import com.repository.IndividualPersonRepository;
import com.repository.LegalPersonRepository;

import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

/*
Are rolul de a executa logica accesata de admin. Functionalitati implementate:
- creaza un nou utilizator (persoana fizica sau juridica)
- creaza un cont de debit pentru un utilizator dupa username
- creaza un cont de credit pentru utilizator dupa username setand o limita pentru cardul de credit
(limita de maxim 100% din salariul clientului sau 10% din capitalul unei firme).
 */

public class AdminService {

    private IndividualPersonRepository individualPersonRepository;
    private LegalPersonRepository legalPersonRepository;

    public AdminService(IndividualPersonRepository individualPersonRepository, LegalPersonRepository legalPersonRepository) {
        this.individualPersonRepository = individualPersonRepository;
        this.legalPersonRepository = legalPersonRepository;
    }

    public void createIndividualPersonUser(String username, String password, String fistName, String lastName, String cnp, double wage){
        this.individualPersonRepository.addUser(username, new IndividualPerson(username, password, fistName, lastName, cnp, wage));
    }

    public void createLegalPersonUser(String username, String password, String companyName, String cui,
                                      double costTransaction, double capital){

    }

    public List<IndividualPerson> getIndividualUsers(){
        return this.individualPersonRepository.getIndividualUsers();
    }

}
