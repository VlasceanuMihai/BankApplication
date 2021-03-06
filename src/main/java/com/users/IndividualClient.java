package com.users;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@Setter
public class IndividualClient extends Client implements Serializable {

    private String firstName;
    private String lastName;
    private String cnp;
    private double wage;

    public IndividualClient(String username, String password, String firstName, String lastName, String cnp, double wage) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "IndividualPerson{" + super.toString() +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", CNP = '" + cnp + '\'' +
                ", wage = '" + wage + '\'' + '}';
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}
