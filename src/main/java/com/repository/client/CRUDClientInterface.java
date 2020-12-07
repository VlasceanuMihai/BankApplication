package com.repository.client;

import java.util.List;
import java.util.Optional;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/5/2020
 */
public interface CRUDClientInterface<T> {

    Optional<T> save(T object);

    boolean delete(String username);

    Optional<T> exists(String username, String password);

    List<T> findAll();

    Optional<T> findById(Long ownerId);

    Optional<T> findByUsername(String username);

    Optional<T> findByClient(T object);

    Long countAll();
}
