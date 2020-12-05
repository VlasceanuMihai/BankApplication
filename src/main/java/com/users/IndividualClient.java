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
public class IndividualClient extends Client implements Serializable {

    private String firstName;
    private String lastName;
    private String cnp;
    private double wage;

    public IndividualClient() {
        super();
    }

    public IndividualClient(String username, String password, String firstName, String lastName, String cnp, double wage) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.wage = wage;
    }
}
