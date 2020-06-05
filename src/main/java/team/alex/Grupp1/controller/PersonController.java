package team.alex.Grupp1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import team.alex.Grupp1.entity.Person;
import team.alex.Grupp1.repositories.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepo;

    /**
    *   Creates a person with given data if provided ssn is not already present in the database.
    *
    *   @param personData - Person-entity model
    *   @return an error message if an entity with given ssn exists otherwise a success message.
    */
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

    /**
        Attempts to delete a Person entry in the database given ssn parameter.

        @param ssn - social security number
        @return a string ' "Deleted: ssn | lastname | firstname | getAge | getGender | getCity | getCountry " ' if an entity with given SSN exists.<br>
        Otherwise an error message indicating that such entity does not exist:<br>
        <i>Error: Entity with SSN '...' doesn't exist.</i>
    */
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


    /**
    *   Retrieves all existing entities(Person) and returns them as an ArrayList<Person>
    *
    *   @return a stringifed version of a list containing info on each entity
    */
    @GetMapping("/fetchAll")
    public ArrayList<Person> getAll() {
    	ArrayList<Person> allRows = new ArrayList<>();
    	
    	allRows.addAll(personRepo.findAll());
    	
        return allRows;
    }

    /**
    *   Retrieves a Person entity by given SSN
    *
    *   @return a ResponseObject containing a stringified version of the retrieved entity if exists, otherwise an error message.
    */
    @GetMapping("/getPersonBySSN/{ssn}")
    public Person getPersonBySSN(@PathVariable long ssn) {

        if(personRepo.existsById(ssn) == true)
            return personRepo.findById(ssn);

        return null;
    }

    /**
    *   Modifies an existing Person-entity.
    *
    *   @param personData - Person-entity model
    *   @return a string containing information on the modified person-entity,<br>
    *   otherwise an error message if the entity doesn't exist.
    */
    @PostMapping("/changePerson")
    public String changePerson(@RequestBody Person personData) {

        if(personRepo.existsById(personData.getSsN()) == false)
            return "such entity does not exist";

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
