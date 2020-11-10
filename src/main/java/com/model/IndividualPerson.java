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
public class IndividualPerson extends Client{

    private String firstName;
    private String lastName;
    private String CNP;
    private double wage;

    public IndividualPerson(String username, String password, String firstName, String lastName, String CNP, double wage) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "IndividualPerson{" +
                "username = " + super.getUsername() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", wage=" + wage +
                '}';
    }
}
