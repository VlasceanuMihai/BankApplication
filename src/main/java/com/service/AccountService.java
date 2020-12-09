package com.service;

import com.dto.AbstractBankAccountDTO;
import com.repository.bankAccounts.BankAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/11/2020
 */

/*
 * Executa logica ce manipuleaza conturile. Functionalitati pentru contul de debit/contul de credit
 */

@Service
@Slf4j
public class AccountService {

    private BankAccountRepository<AbstractBankAccountDTO> bankAccountRepository;

    @Autowired
    public AccountService(BankAccountRepository<AbstractBankAccountDTO> bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }


}
