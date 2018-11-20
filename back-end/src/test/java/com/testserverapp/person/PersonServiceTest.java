package com.testserverapp.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

// import com.google.gson.Gson;
// import com.google.gson.JsonObject;
import com.testserverapp.entity.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void createPersonSucess() {

        Person personPersisted = null;
        try {

            // Creating person
            Person person = createPerson();
            personPersisted = (Person) personService.savePerson(person);
        } catch (Exception e) {
            System.out.print(e);
        }

        if (personPersisted != null) {
            assertEquals("54647142949", personPersisted.getCpf());
        } else {
            assertNotNull(personPersisted);
        }
    }

    @Test
    public void createPersonDuplicate() {

        Person person = null;
        Person personPersisted = null;

        try {

            // Finding person
            person = personService.findPersonByCpf("54647142949");

            // Creating person
            if (person == null) {
                person = createPerson();
                person = (Person) personService.savePerson(person);
            }

            // Creating duplicated person
            personPersisted = (Person) personService.savePerson(person);
        } catch (Exception e) {
        }

        assertNull(personPersisted);

    }

    @Test
    public void updatePersonSucess() {

        // Finding person
        Person person = personService.findPersonByCpf("54647142949");

        // Creating person
        if (person == null) {
            person = createPerson();
            person = (Person) personService.savePerson(person);
        }

        if (person != null) {
            Person personPersisted = null;
            try {
                // Updating person name
                person.setName("Name Test update");
                personPersisted = personService.savePerson(person);
            } catch (Exception e) {
                throw new RuntimeException("Erro creating Person");
            }

            if (personPersisted != null) {
                assertEquals("Name Test update", personPersisted.getName());
            } else {
                assertNotNull(personPersisted);
            }
        } else {
            throw new RuntimeException("Erro creating Person");
        }
    }

    @Test
    public void findPersonByCpfSucess() {

        Person person = personService.findPersonByCpf("54647142949");
        if (person != null) {
            assertEquals("54647142949", person.getCpf());
        }
    }

    @Test
    public void findPersonByIdSucess() {

        Optional<Person> opPerson = personService.findPersonById("1");
        Person person = opPerson.get();
        if (person != null) {
            assertEquals("1", person.getId());
        }
    }

    @Test
    public void findPersonByNameSucess() {
        Person person = personService.findPersonByName("Name Test update");

        if (person != null) {
            assertEquals("Name Test update", person.getName());
        }
    }

    @Test
    public void findAllSucess() {
        List<Person> people = personService.findAllPerson();

        if (people != null && people.size() > 0) {

            assertEquals("54142647949", people.get(0).getCpf());

        }
    }

    @Test
    public void deletePersonSucess() {

        Person person = personService.findPersonByCpf("54647142949");

        try {
            personService.deletePerson(person);
        } catch (Exception e) {
            throw new RuntimeException("Erro deletting Person");
        }

        person = personService.findPersonByCpf("54142647949");
        assertNull(person);

    }

    private Person createPerson() {

        Person person = new Person();

        person.setName("Name Test");
        person.setCpf("54647142949");
        person.setAdress(" Test Street");
        person.setCity("Test City");
        person.setUf("PE");
        person.setEmail("emailTest@test.com.br");
        person.setTelephone("81 33334444");
        person.setObs("Test observation");

        return person;
    }

}