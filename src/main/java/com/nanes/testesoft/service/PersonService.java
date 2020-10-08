package com.nanes.testesoft.service;

import com.nanes.testesoft.model.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PersonService extends CrudService<Person, Long> {
    Optional<Person> findByName(String nickname);
}
