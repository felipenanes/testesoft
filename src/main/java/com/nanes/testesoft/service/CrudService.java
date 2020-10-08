package com.nanes.testesoft.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public interface CrudService<T, ID extends Serializable> {

    Optional<T> findById(ID id);

    List<T> findAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}