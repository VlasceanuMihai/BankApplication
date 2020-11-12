package com.dto;

import java.util.UUID;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/7/2020
 */

// DebitBankAccountDTO (DTO = data transfer object) contine datele unui cont de debit: id, IBAN, amount, ownerId

public class DebitBankAccountDTO {

    private static Long id;
    private Long ownerId;
    private UUID iban;
    private double amount;

    public DebitBankAccountDTO(Long ownerId, double amount) {
        id++;
        this.ownerId = ownerId;
        this.iban = UUID.randomUUID();;
        this.amount = amount;
    }
}
