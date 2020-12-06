package com.dto;

import com.enums.BankAccountType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/7/2020
 */

/*
 * DebitBankAccountDTO contine datele unui cont de debit
 */

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DebitBankAccountDTO extends AbstractBankAccountDTO{

    public DebitBankAccountDTO(BankAccountType bankAccountType, Long ownerId, double amount) {
        super(bankAccountType, ownerId, amount);
    }
}
