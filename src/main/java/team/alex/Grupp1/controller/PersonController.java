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

        // TODO : Insert into database

        return new ResponseObject("[POST] OK");
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseObject deletePerson(@PathVariable int id) {

    	// TODO: Delete from db

        return new ResponseObject("[DELETE] OK :: " + id);
    }


    @GetMapping("/fetchAll")
    public ResponseObject getAll() {

        // TODO: Fetch all entries from database
        return new ResponseObject("get all - OK");
    }

    @GetMapping("/getPersonById/{id}")
    @ResponseBody
    public ResponseObject getPersonById(@PathVariable int id) {

        // TODO: Fetch from database
        return new ResponseObject("getPersonByID - OK :: " + id);
    }

    @GetMapping("/getPersonBySSN/{ssn}")
    public ResponseObject getPersonBySSN(@PathVariable int ssn) {

        // TODO: Fetch from database
        return new ResponseObject("getPersonBySSN - OK :: " + ssn);
    }

}
