package fi.niskasam.HomeThings.domain;

import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Long> {
	

}
