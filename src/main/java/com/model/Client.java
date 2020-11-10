package com.model;

import com.dto.CreditBankAccountDTO;
import com.dto.DebitBankAccountDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/4/2020
 */

@Getter
@Setter
public abstract class Client {

    private static Long id = 0L;
    private String username;
    private String password;
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
        return "Client{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
