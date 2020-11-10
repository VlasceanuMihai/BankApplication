package com.dto;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/7/2020
 */

// DebitBankAccountDTO (DTO = data transfer object) contine datele unui cont de debit: id, IBAN, amount, ownerId

public class DebitBankAccountDTO {

    private Long id;
    private Long ownerId;
    private String iban;
    private double amount;
}
