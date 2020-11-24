package com.dto;

import lombok.Data;
import lombok.Getter;

import java.util.UUID;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/7/2020
 */

// DebitBankAccountDTO (DTO = data transfer object) contine datele unui cont de debit: id, IBAN, amount, ownerId

@Data
public class DebitBankAccountDTO {

    @Getter
    private static Long counter = 0L;
    private Long id = 0L;
    private Long ownerId;
    private UUID iban;
    private double amount;

    public DebitBankAccountDTO(Long ownerId, double amount) {
        this.id = counter++;
        this.ownerId = ownerId;
        this.iban = UUID.randomUUID();;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DebitBankAccountDTO{" +
                "id = " + this.id +
                ", ownerId = " + this.ownerId +
                ", iban = " + this.iban +
                ", amount = " + this.amount +
                '}';
    }
}
