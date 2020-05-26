package team.alex.Grupp1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	private Person person;

	@BeforeAll
	public void beforeAllTests() {
		ssn = 1L;

		// Create and store test entity

		person = new Person("Pepe", "Frog", 20, 'm', ssn, "City", "Country");
		personRepo.save(person);

		person = new Person("Pepe", "Frog", 20, 'm', ssn + 1, "City", "Country");
		personRepo.save(person);

		person = new Person("Pepe", "Frog", 20, 'm', ssn + 2, "City", "Country");
		personRepo.save(person);

		person = new Person("Pepe", "Frog", 20, 'm', ssn + 3, "City", "Country");
		personRepo.save(person);
		

		person = new Person("Jonas", "Sjöstedt", 41, 'm', ssn + 4, "Malmö", "Sweden");
		personRepo.save(person);

	}

	@Test
	void testGetRowsAfterDelete() {
		// delete last person
		personRepo.delete(person);

		assertEquals(3, personRepo.count());
	}

	@Test
	@DisplayName("Test1")
	public void testNumberOfRows() {
		assertTrue(personRepo.findAll().size() == 3);
	}

	@Test
	@DisplayName("Test4")
	public void testIfRowExists() {
		assertFalse(personRepo.existsById(ssn));
	}

	@Test
	public void testGetExpectedRows() {
		assertEquals(4, personRepo.count());

	}
}
