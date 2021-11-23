package fi.niskasam.HomeThings.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Long> {
	
//	@Bean
//	public default CommandLineRunner demo(ThingRepository repo) {
//		return (args) -> {
//			Thing first = new Thing("Test 1", "This is a test data 1", null, null);
//			Thing second = new Thing("Test 2", "This is a test data 2", null, null);
//			Thing third = new Thing("Test 3", "This is a test data 3", null, null);
//			
//			repo.save(first);
//			repo.save(second);
//			repo.save(third);
//		};
//	}

}
