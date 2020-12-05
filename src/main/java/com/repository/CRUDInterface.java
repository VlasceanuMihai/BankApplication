package com.repository;

import java.util.List;
import java.util.Optional;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 12/5/2020
 */
public interface CRUDInterface<T> {

    Optional<T> save(T object);

    boolean delete(String username);

//    boolean exists(String username);

    List<T> findAll();

    Optional<T> findById(Long ownerId);

    Optional<T> findByUsername(String username);

    Optional<T> findByClient(T object);

    Long countAll();


}
