package fi.niskasam.HomeThings.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.niskasam.HomeThings.domain.Thing;
import fi.niskasam.HomeThings.domain.ThingRepository;


@Controller
public class HomePageController {
	
	@Autowired
	private ThingRepository repo;
	
	@RequestMapping("/index")
	public String homeThings(Model model) {
		return "index";
	}

	//LOGIN
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	
	
	//READ

		@RequestMapping(value = "/things", method=RequestMethod.GET)
		public String things(Model model) {
			model.addAttribute("things", repo.findAll());
			return "things";
		}
	
	//CREATE
	
	
		@RequestMapping("/add")
		public String addThing(Model model) {
			model.addAttribute("thing", new Thing());
			return "addthing";
	
		}
	
	// SAVE
	
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Thing thing) {
			repo.save(thing);
			return "redirect:things";
		}
		
	// UPDATE
		
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		public String editThing(@PathVariable("id") Long id, Model model) {
			model.addAttribute("thing", repo.findById(id));
			return "editthing";
		}

		
	// DELETE
		@PreAuthorize("hasAuthority('ADMIN')")
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteThing(@PathVariable("id") Long id, Model model) {
			repo.deleteById(id);
			return "redirect:../index";
		}
		
}
