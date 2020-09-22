package com.nanes.testesoft.service;

import com.nanes.testesoft.model.Person;

import java.util.Optional;

public interface PersonService extends CrudService<Person, Long> {
    Optional<Person> findByName(String nickname);
}
