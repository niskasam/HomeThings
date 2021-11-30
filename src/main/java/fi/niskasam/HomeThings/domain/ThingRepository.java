package fi.niskasam.HomeThings.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ThingRepository extends CrudRepository<Thing, Long> {

	List<Thing> findByTitle(String title);

	List<Thing> findByDescription(String description);

	List<Thing> findByOwner(String owner);

}
