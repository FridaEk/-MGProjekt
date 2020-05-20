package team.alex.Grupp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.alex.Grupp1.entity.Person;
import team.alex.Grupp1.repositories.PersonRepository;

@SpringBootTest
class Grupp1ApplicationTests {

	@Autowired
	private PersonRepository personRepo;

    @Test
	void testGetRowsAfterDelete() {

		// Create and store test entity
		long ssn = 1L;

		Person person = new Person("Pepe","Frog",20,'m',ssn,"City","Country");
        personRepo.save(person);

        person = new Person("Pepe","Frog",20,'m',ssn+1,"City","Country");
        personRepo.save(person);

        person = new Person("Pepe","Frog",20,'m',ssn+2,"City","Country");
        personRepo.save(person);

        person = new Person("Pepe","Frog",20,'m',ssn+3,"City","Country");
        personRepo.save(person);

        // delete last person
        personRepo.delete(person);

        assertEquals(3, personRepo.count());
	}

}
