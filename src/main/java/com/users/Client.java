package com.users;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@EqualsAndHashCode(of = {"username", "password"})
@ToString(of = {"username", "password", "debitList", "creditList"})
public abstract class Client implements Comparable<Client>{

    private static Long counter = 0L;
    private static Long numberOfClients = 0L;
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

    private Long uniqId = 0L;

    public Client(String username, String password) {
        ++numberOfClients;
        this.username = username;
        this.password = password;
        this.debitList = new ArrayList<>();
        this.creditList = new ArrayList<>();
    }

    public Client() {}

    public void generateId() {
        this.uniqId = counter++;
    }

    public void decrementNumberOfClients(){
        numberOfClients--;
    }

//    @Override
//    public String toString() {
//        return "id = " + this.getUniqId() + '\'' +
//                ", username = '" + this.getUsername() + '\'' +
//                ", debitAccounts = '" + this.getDebitList().size() + '\'' +
//                ", creditAccounts = '" + this.getCreditList().size() + '\'';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || this.getClass() != o.getClass()) return false;
//
//        Client client = (Client) o;
//        return this.username.equals(client.username);
//    }
//
//    @Override
//    public int hashCode() {
//        int prime = 31;
//        int result = 1;
//        result = prime * result + ((this.username == null) ? 0 : username.hashCode());
//        return result;
//    }

    @Override
    public int compareTo(Client o) {
        if (!this.getUsername().equals(o.getUsername())){
            return o.getUsername().compareTo(o.getUsername());
        }
        return this.getUsername().compareTo(o.getUsername());
    }
}
