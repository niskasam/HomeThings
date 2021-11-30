package fi.niskasam.HomeThings;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.niskasam.HomeThings.domain.Category;
import fi.niskasam.HomeThings.domain.CategoryRepository;
import fi.niskasam.HomeThings.domain.Thing;
import fi.niskasam.HomeThings.domain.ThingRepository;

@SpringBootTest
public class HomeThingsRepoTest {

	@Autowired
	ThingRepository tRepo;
	CategoryRepository cRepo;

	@Test
	public void findByTitleRetrunSize() {
		List<Thing> things = tRepo.findByTitle("test");
		Assertions.assertThat(things).hasSize(4);
	}

	@Test
	public void insertNewThing() {
		String title = "Test 1";
		String description = "Test 1 description";
		Category categoryid = new Category(1, description);
		LocalDate reg_date = LocalDate.of(2021, 11, 28);
		LocalDate due_date = LocalDate.of(2021, 12, 03);
		Thing thing = new Thing(categoryid, title, description, due_date, reg_date, description);
		tRepo.save(thing);
		List<Thing> things = tRepo.findByTitle("Test 1");
		Assertions.assertThat(things.get(0).getTitle()).isEqualTo("Test 1");
	}

	@Test
	public void deleteThing() {
		List<Thing> things = tRepo.findByTitle("Test 1");
		tRepo.deleteById(things.get(0).getId());
		things = tRepo.findByTitle("Test 1");
		Assertions.assertThat(things).hasSize(4);
	}

}
