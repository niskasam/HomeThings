package fi.niskasam.HomeThings.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.niskasam.HomeThings.domain.Thing;
import fi.niskasam.HomeThings.domain.ThingRepository;

@RestController
public class ThingRestController {

	@Autowired
	ThingRepository tRepo;

	@GetMapping(value = "/asiat")
	public List<Thing> thingListRest() {
		return (List<Thing>) tRepo.findAll();
	}

}
