package com.nanes.testesoft.controller;

import com.nanes.testesoft.model.Person;
import com.nanes.testesoft.service.PersonService;
import javassist.expr.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import com.nanes.testesoft.utils.JavaUtils;

@RestController
@RequestMapping(path = "person")
public class PersonController {
    @Autowired
    private final PersonService service;

    public PersonController(PersonService personService) {
        this.service = personService;
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Person successfully deleted!");
    }
}
