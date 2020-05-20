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
        return new ResponseObject("[POST] OK");
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseObject deletePerson(@PathVariable int id) {

    	// TODO: Delete from db

        return new ResponseObject("[DELETE] OK :: " + id);
    }


    /*
    * Retrieves all existing entities(Person) and returns them as an ArrayList<Person>
    */
    @GetMapping("/fetchAll")
    public ArrayList<Person> getAll() {
        return personRepo.findAll();
    }

    /*
    * Retrieves a Person entity by given SSN id
    */
    @GetMapping("/getPersonBySSN/{ssn}")
    public Person getPersonBySSN(@PathVariable long ssn) {
        return personRepo.findById(ssn);
    }

    @PostMapping("/changePerson")
    public ResponseObject changePerson(@RequestBody Person personData) {

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
        // TODO : Insert into database

        return new ResponseObject("[POST] OK");
    }

}
