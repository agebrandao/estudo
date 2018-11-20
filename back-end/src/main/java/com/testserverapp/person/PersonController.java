package com.testserverapp.person;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.testserverapp.entity.Person;
import com.testserverapp.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testserverapp/person")
@CrossOrigin(origins = "*") //Access from any port
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create( HttpServletRequest request, @RequestBody Person person, BindingResult result){

        try {
            validateCreatePerson(person, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(person);        
            }
            
            //Creates or updates the user
            Person personPersisted = (Person) personService.savePerson(person);
            return ResponseEntity.ok(personPersisted);            

        } catch (Exception e) {           
            return ResponseEntity.badRequest().body(person); 
            
        }
    }

    private void validateCreatePerson(Person person, BindingResult result){
        if(person.getCpf() == null){

            Person personExists = personService.findPersonByCpf(person.getCpf());
            if (personExists != null) {
                result.addError(new ObjectError("Person", "CPF no information"));
            }
        }
    }

    @PutMapping
    public ResponseEntity<Person> update( HttpServletRequest request, @RequestBody Person person, BindingResult result){

        try {
            validateUpdatePerson(person, result);
            if(result.hasErrors()){                        
                return ResponseEntity.badRequest().body(person);        
            }
            
            //Creates or updates the user
            Person personPersisted = (Person) personService.savePerson(person);
            return ResponseEntity.ok(personPersisted);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(person); 
            
        }
    }

    private void validateUpdatePerson(Person person, BindingResult result) {
		if (person.getId() == null) {
			result.addError(new ObjectError("Person", "Id no information"));
			return;
		}
		if (person.getCpf() == null) {
			result.addError(new ObjectError("Person", "CPF no information"));
			return;
		}
    }
    
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {

		Optional<Person> opPerson = personService.findPersonById(id);
		Person person =  opPerson.get();

		if (person == null) {
			return ResponseEntity.badRequest().body("Register not found id: "  + person); 
		}
        personService.deletePerson(person);
    
		return ResponseEntity.ok("Register found id: " + person);
	}

    @GetMapping
	public ResponseEntity<List<Person>> findByAll() {

		List<Person> people = personService.findAllPerson();	

		if (people == null) {
			return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(people);    

    }

    @GetMapping(value = "{id}")
	public ResponseEntity<Person> findById(@PathVariable("id") String id) {

		Optional<Person> opPerson = personService.findPersonById(id);
		Person person =  opPerson.get();

		if (person == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(person);
    }
    
    @GetMapping(value = "{cpf}")
	public ResponseEntity<Person> findByCpf(String cpf) {

		Person person = personService.findPersonByCpf(cpf);		

		if (person == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(person);
	}

}