package com.repository.bankAccounts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/6/2020
 */
public interface CRUDBankAccountsInterface<T> {

    Optional<T> save(T object);

    boolean existsBasedOnIban(UUID iban);

    List<T> findAll();

    List<T> findAllByOwnerId(Long ownerId);

    Optional<T> findByIban(UUID iban);

    Optional<T> findByBankAccount(T object);

    Long countAll();
}
