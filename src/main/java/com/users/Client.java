package com.users;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@EqualsAndHashCode(of = {"username"})
@ToString(of = {"username", "password", "debitList", "creditList"})
public abstract class Client implements Comparable<Client> {

    private static Long counter = 0L;
    @Getter
    private static Long numberOfClients = 0L;

    private Long id = 0L;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private boolean isLogged;
    @Setter
    private List<DebitBankAccountDTO> debitList;
    @Setter
    private List<CreditBankAccountDTO> creditList;



    public Client() {
    }

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        this.debitList = new ArrayList<>();
        this.creditList = new ArrayList<>();
    }

    public void generateId() {
        this.id = counter++;
        ++numberOfClients;
    }

    public void decrementNumberOfClients() {
        numberOfClients--;
    }


    @Override
    public int compareTo(Client o) {
        if (!this.getUsername().equals(o.getUsername())) {
            return this.getUsername().compareTo(o.getUsername());
        }
        return this.getUsername().compareTo(o.getUsername());
    }
}
