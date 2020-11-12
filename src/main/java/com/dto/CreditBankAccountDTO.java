package com.dto;

import lombok.Getter;

import java.util.UUID;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/7/2020
 */

// CreditBankAccountDTO contine datele unui cont de credit: id, amount, ownerId, limitAmount

@Getter
public class CreditBankAccountDTO {

    private double limitAmount;
    private static Long counter = 0L;
    private Long id = 0L;
    private Long ownerId;
    private UUID iban;
    private double amount;

    public CreditBankAccountDTO(Long ownerId, double amount, double limitAmount) {
        this.id = counter++;
        this.ownerId = ownerId;
        this.iban = UUID.randomUUID();;
        this.amount = amount;
        this.limitAmount = limitAmount;
    }

    @Override
    public String toString() {
        return "CreditBankAccountDTO{" +
                "id = " + this.id +
                ", ownerId = " + this.ownerId +
                ", iban = " + this.iban +
                ", amount = " + this.amount +
                ", limitAmount = " + this.limitAmount +
                '}';
    }
}
