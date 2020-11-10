package com.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@Setter
public class LegalPerson extends Client{

    private String companyName;
    private String cui;
    private double costTransaction;
    private double capital;

    public LegalPerson(String username, String password, String companyName, String cui, double costTransaction, double capital) {
        super(username, password);
        this.companyName = companyName;
        this.cui = cui;
        this.costTransaction = costTransaction;
        this.capital = capital;
    }
}
