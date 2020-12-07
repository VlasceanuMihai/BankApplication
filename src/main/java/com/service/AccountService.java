package com.service;

import com.dto.AbstractBankAccountDTO;
import com.repository.bankAccounts.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */

@Service
public class AccountService {

    private BankAccountRepository<AbstractBankAccountDTO> bankAccountRepository;

    @Autowired
    public AccountService(BankAccountRepository<AbstractBankAccountDTO> bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


}
