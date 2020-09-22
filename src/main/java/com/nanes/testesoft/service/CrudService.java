package com.nanes.testesoft.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID extends Serializable> {

    Optional<T> findById(ID id);

    List<T> findAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}