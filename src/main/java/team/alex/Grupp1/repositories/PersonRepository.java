package team.alex.Grupp1.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import team.alex.Grupp1.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	// Overrides default findAll to return
	// an ArrayList of Person entities
	ArrayList<Person> findAll();

	// Overrides default findById to return
	// a Person entity instead of Optional<Object>
	Person findById(long ssn);

}
