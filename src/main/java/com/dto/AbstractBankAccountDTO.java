package com.dto;

import com.enums.BankAccountType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */

@Getter
@ToString(of = {"bankAccountType", "id", "iban", "amount", "ownerId"})
@EqualsAndHashCode(of = "iban")
public abstract class AbstractBankAccountDTO {

    private static Long counter = 0L;
    private Long id = 0L;

    private BankAccountType bankAccountType;
    private Long ownerId;
    private UUID iban;
    private double amount;

    public AbstractBankAccountDTO(BankAccountType bankAccountType, Long ownerId, double amount) {
        this.id = counter++;
        this.bankAccountType = bankAccountType;
        this.iban = UUID.randomUUID();
        this.ownerId = ownerId;
        this.amount = amount;
    }
}
