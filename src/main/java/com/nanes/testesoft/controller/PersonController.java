package com.nanes.testesoft.controller;

import com.google.gson.Gson;
import com.nanes.testesoft.model.Person;
import com.nanes.testesoft.repository.PersonRepository;
import com.nanes.testesoft.service.PersonService;
import com.nanes.testesoft.utils.JavaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "person")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PersonController {
    @Autowired
    private final PersonService service;

    @Autowired
    private final PersonRepository repository;

    private static final Gson gson = new Gson();

    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.service = personService;
        this.repository = personRepository;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> userList = service.findAll();
        return userList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(userList);
    }

    @PostMapping(path = "")
    public ResponseEntity<Person> save(@RequestBody @Valid Person body) {
        Person user = service.save(body);
        return ResponseEntity.ok(user);
    }

    @PutMapping(path = "/change/{id}")
    public ResponseEntity<Person> update(@RequestBody @Valid Person body, @PathVariable("id") Long id) {
        Person user = service.findById(id).orElse(null);
        Person newUser = new Person();
        if(user != null) {
            newUser = JavaUtils.copyProperties(user, body);
            newUser = service.save(newUser);
            return ResponseEntity.ok(newUser);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(path = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        System.out.println("Deleting product with id: " + id);
        repository.deleteById(id);
        return ResponseEntity.ok(gson.toJson("Person successfully deleted!"));
    }
}
