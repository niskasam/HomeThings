package fi.niskasam.HomeThings;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.niskasam.HomeThings.domain.Thing;
import fi.niskasam.HomeThings.domain.ThingRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class HomeThingsApplicationTests {
	
	@Autowired
	private ThingRepository repo;

	@Test
	public void findByDescription() {
		LocalDate testRegDate = LocalDate.parse("2020-01-01");
		LocalDate testDueDate = LocalDate.parse("2020-12-31");
		Thing thing = new Thing("Test title", "Test desc", testRegDate, testDueDate);	
		repo.save(thing);
	}

}
