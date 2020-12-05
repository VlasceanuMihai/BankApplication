package com.users;

import lombok.*;

import java.io.Serializable;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LegalClient extends Client implements Serializable {

    private String companyName;
    private String cui;
    private double costTransaction;
    private double capital;

    public LegalClient() {
    }

    public LegalClient(String username, String password, String companyName, String cui, double costTransaction, double capital) {
        super(username, password);
        this.companyName = companyName;
        this.cui = cui;
        this.costTransaction = costTransaction;
        this.capital = capital;
    }
}
