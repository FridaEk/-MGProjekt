package team.alex.Grupp1.repositories;

import org.springframework.data.repository.CrudRepository;

import team.alex.Grupp1.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Person findByssN(long ssN);
}

