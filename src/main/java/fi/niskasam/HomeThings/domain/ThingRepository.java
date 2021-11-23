package fi.niskasam.HomeThings.domain;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import groovy.lang.Category;

public interface ThingRepository extends CrudRepository<Thing, Long> {
	

}
