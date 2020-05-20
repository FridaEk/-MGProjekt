package team.alex.Grupp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import team.alex.Grupp1.repositories.PersonRepository;

@SpringBootTest
class Grupp1ApplicationTests {

	private static long ssn;
	
	@Autowired
	PersonRepository personRepo;
	
	@BeforeAll
	public static void beforeAllTests() {
		ssn = 101010;
	}
	
	@Test
	@DisplayName("Test4")
	public void testIfRowExists() {
		assertFalse(personRepo.existsById(ssn));
	}

	
}
