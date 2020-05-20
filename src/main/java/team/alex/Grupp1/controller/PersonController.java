package team.alex.Grupp1.controller;

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
    public ResponseObject deletePerson(@PathVariable Long ssn) {
    	  personRepo.deleteById(ssn);
        return new ResponseObject("[DELETE] OK :: " + ssn);
    }

    @GetMapping("/fetchAll")
    public ResponseObject getAll() {

        // TODO: Fetch all entries from database
        return new ResponseObject("get all - OK");
    }
  
    @GetMapping("/getPersonBySSN/{ssn}")
    public ResponseObject getPersonBySSN(@PathVariable int ssn) {

        // TODO: Fetch from database
        return new ResponseObject("getPersonBySSN - OK :: " + ssn);
    }
    
    @PostMapping("/changePerson")
    public ResponseObject changePerson(@RequestBody Person personData) {
    	
    	Person oldPerson = personRepo.findByssN(personData.getSsN());

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

        return new ResponseObject("[POST] OK");
    }

}
