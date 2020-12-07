package com.repository.bankAccounts;

import com.dto.AbstractBankAccountDTO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */

@Component
public class BankAccountRepository<T extends AbstractBankAccountDTO> implements CRUDBankAccountsInterface<T>, Serializable {

    private final List<T> bankAccounts = new ArrayList<>();

    @Override
    public Optional<T> save(T bankAccount) {
        Optional<T> account = this.findByBankAccount(bankAccount);
        if (!account.isPresent()){
            this.bankAccounts.add(bankAccount);
        }

        return account;
    }

    @Override
    public boolean existsBasedOnIban(UUID iban) {
        Optional<T> bankAccount = this.findByIban(iban);
        return bankAccount.isPresent();
    }

    @Override
    public List<T> findAll() {
        return this.bankAccounts;
    }

    @Override
    public List<T> findAllByOwnerId(Long ownerId) {
        return this.bankAccounts.stream().filter(account -> account.getOwnerId().equals(ownerId)).collect(Collectors.toList());
    }

    @Override
    public Optional<T> findByIban(UUID iban) {
        return this.bankAccounts.stream().filter(account -> account.getIban().equals(iban)).findFirst();
    }

    @Override
    public Optional<T> findByBankAccount(T object) {
        return this.bankAccounts.stream().filter(account -> account.equals(object)).findFirst();
    }

    @Override
    public Long countAll() {
        return (long) this.bankAccounts.size();
    }
}
