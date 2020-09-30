package com.nanes.testesoft.service.impl;

import com.nanes.testesoft.exception.PersonAlreadyExistsException;
import com.nanes.testesoft.model.Person;
import com.nanes.testesoft.repository.PersonRepository;
import com.nanes.testesoft.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Person> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Person> findByName(String nickname) { return repository.findByName(nickname); }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person save(Person person) {
        findByName(person.getCpf()).ifPresent(found -> {
            if(found.getId().equals(person.getId())) {
                throw new PersonAlreadyExistsException(found.getCpf());
            }
        });
        return repository.save(person);
    }

    @Override
    public Person update(Person player) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}