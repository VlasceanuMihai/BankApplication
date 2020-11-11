package com.users;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@Setter
public abstract class Client implements Comparable<Client>{

    @Getter
    @Setter
    private static Long id = 0L;
    private String username;
    private String password;
    private boolean isLogged;
    private List<DebitBankAccountDTO> debitList;
    private List<CreditBankAccountDTO> creditList;

    public Client(String username, String password) {
        id++;
        this.username = username;
        this.password = password;
        this.debitList = new ArrayList<>();
        this.creditList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "id = " + id + '\'' +
                ", username = '" + this.username + '\'' +
                ", debitAccounts = '" + this.debitList.size() + '\'' +
                ", creditAccounts = '" + this.creditList.size() + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Client client = (Client) o;
        return this.username.equals(client.username);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((this.username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public int compareTo(Client o) {
        if (!this.getUsername().equals(o.getUsername())){
            return o.getUsername().compareTo(o.getUsername());
        }
        return this.getUsername().compareTo(o.getUsername());
    }
}
