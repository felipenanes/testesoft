package com.nanes.testesoft.controller;

import com.nanes.testesoft.model.Person;
import com.nanes.testesoft.repository.PersonRepository;
import com.nanes.testesoft.service.impl.PersonServiceImpl;
import manual.DummyGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonControllerTest {

    private final DummyGenerator dummyGenerator = new DummyGenerator();

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test //assert saving ok
    public void givenPerson_whenSavePerson_thenOK() throws Exception {
        Person dummy = dummyGenerator.generateDummyPerson();
        when(personRepository.save(dummy)).thenReturn(dummy);
        Person person = personService.save(dummy);
        assertNotNull(person);
    }

    @Test //assert errors junit5
    public void givenBrokenPerson_whenSavePerson_thenError() throws Exception {
        Person dummy = dummyGenerator.generateDummyPerson();
        dummy.setCpf(null);
        when(personRepository.save(dummy)).thenThrow(new IllegalArgumentException());
        Assertions.assertThrows(IllegalArgumentException.class, () -> { personService.save(dummy); });
    }
}