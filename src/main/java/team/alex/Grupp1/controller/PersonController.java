package team.alex.Grupp1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team.alex.Grupp1.entity.Person;
import team.alex.Grupp1.repositories.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepo;

    @PostMapping("/createPerson")
    public ResponseObject createPerson(@RequestBody Person personData) {
    	
    	// make sure an existing person is not overriden
    	if(personRepo.existsById(personData.getSsN()) == true)
    		return new ResponseObject("ERROR: User with SSN '"+personData.getSsN()+"' already exists.");

        Person person = new Person(
            personData.getFirstName(),
            personData.getLastName(),
            personData.getAge(),
            personData.getGender(),
            personData.getSsN(),
            personData.getCity(),
            personData.getCountry()
        );
      
        personRepo.save(person);
        return new ResponseObject("Created: " + person.toString());
    }

    @DeleteMapping("/deletePerson/{ssn}")
    public ResponseObject deletePerson(@PathVariable long ssn) {
    	
    	// validate that entity with given SSN exists
    	if(personRepo.existsById(ssn) == false) {
    		return new ResponseObject("ERROR: Entity with SSN '"+ssn+"' doesn't exist.");
		}
    	
    	Person deletedPerson = personRepo.findById(ssn);
    	personRepo.deleteById(ssn);
    	return new ResponseObject("Deleted: " + deletedPerson.toString());
    }


    /*
    * Retrieves all existing entities(Person) and returns them as an ArrayList<Person>
    */
    @GetMapping("/fetchAll")
    public String getAll() {
    	ArrayList<Person> allRows = new ArrayList<>();
    	
    	allRows.addAll(personRepo.findAll());
    	
    	StringBuilder fetchedData = new StringBuilder();
    	
    	for (Person p : allRows) {
    		fetchedData.append(p.toString());
    		fetchedData.append("\n");
    	}
    	
        return fetchedData.toString();
    }

    /*
    * Retrieves a Person entity by given SSN id
    */
    @GetMapping("/getPersonBySSN/{ssn}")
    public String getPersonBySSN(@PathVariable long ssn) {
        return personRepo.findById(ssn).toString();
    }

    @PostMapping("/changePerson")
    public String changePerson(@RequestBody Person personData) {

    	Person oldPerson = personRepo.findById(personData.getSsN());

        Person newPerson = new Person(
            personData.getFirstName(),
            personData.getLastName(),
            personData.getAge(),
            personData.getGender(),
            personData.getSsN(),
            personData.getCity(),
            personData.getCountry()
        );
        
        oldPerson = newPerson;

        personRepo.save(oldPerson);

        return "Changed:\n" + newPerson.toString();
    }

}
