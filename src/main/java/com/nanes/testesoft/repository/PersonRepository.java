package com.nanes.testesoft.repository;

import com.nanes.testesoft.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String nickname);
}
