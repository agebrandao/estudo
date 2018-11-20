package com.testserverapp.person;

import java.util.List;
import java.util.Optional;

import com.testserverapp.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> findPersonById(@PathVariable String id) {
        return personRepository.findById(id);
    }

    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    public Person findPersonByName(String name) {
        return personRepository.findByName(name);
    }

    public Person findPersonByCpf(String cpf) {
        return personRepository.findByCpf(cpf);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

}