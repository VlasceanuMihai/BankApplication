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
 * Contine datele unui cont de credit
 */

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CreditBankAccountDTO extends AbstractBankAccountDTO{

    private double limitAmount;

    public CreditBankAccountDTO(BankAccountType bankAccountType, Long ownerId, double amount, double limitAmount) {
        super(bankAccountType, ownerId, amount);
        this.limitAmount = limitAmount;
    }


}
