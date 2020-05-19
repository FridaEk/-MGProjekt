package team.alex.Grupp1.repositories;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {}