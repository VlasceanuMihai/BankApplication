package com.repository;

import java.util.Optional;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/5/2020
 */
public interface CRUDInterface<T> {

    T save(T object);

    void delete(String username);

    boolean exists(String username);

    Iterable<T> findAll();

    Optional<T> find(String username);

    Optional<T> find(T object);

    Long countAll();


}
