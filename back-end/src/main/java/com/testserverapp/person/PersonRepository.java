package com.testserverapp.person;

import java.util.List;
import java.util.Optional;

import com.testserverapp.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(@PathVariable String id);    
    List<Person> findAll();
    Person findByName(String name);
    Person findByCpf(String cpf);
}