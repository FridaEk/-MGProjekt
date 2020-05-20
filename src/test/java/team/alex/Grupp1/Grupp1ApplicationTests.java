package team.alex.Grupp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.alex.Grupp1.entity.Person;
import team.alex.Grupp1.repositories.PersonRepository;

import team.alex.Grupp1.repositories.PersonRepository;

@SpringBootTest
class Grupp1ApplicationTests {

	@Autowired
	private PersonRepository personRepo;

	private static long ssn;

	@BeforeAll
	public static void beforeAllTests() {
		ssn = 1L;
	}

	@Test
	void testGetRowsAfterDelete() {

		// Create and store test entity

		Person person = new Person("Pepe", "Frog", 20, 'm', ssn, "City", "Country");
		personRepo.save(person);

		person = new Person("Pepe", "Frog", 20, 'm', ssn + 1, "City", "Country");
		personRepo.save(person);

		person = new Person("Pepe", "Frog", 20, 'm', ssn + 2, "City", "Country");
		personRepo.save(person);

		person = new Person("Pepe", "Frog", 20, 'm', ssn + 3, "City", "Country");
		personRepo.save(person);

		// delete last person
		personRepo.delete(person);

		assertEquals(3, personRepo.count());
	}

	@Test
	@DisplayName("Test4")
	public void testIfRowExists() {
		assertFalse(personRepo.existsById(ssn));
	}

}
