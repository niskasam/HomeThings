package fi.niskasam.HomeThings.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.niskasam.HomeThings.domain.Thing;
import fi.niskasam.HomeThings.domain.ThingRepository;

@Controller
public class HomePageController {

	@Autowired
	private ThingRepository repo;

	@Autowired
	private fi.niskasam.HomeThings.domain.CategoryRepository categoryRepository;

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String homeThings(Model model) {
		return "index";
	}

	@RequestMapping("/help")
	public String help(Model model) {
		return "help";
	}

	// READ
	@RequestMapping(value = "/things", method = RequestMethod.GET)
	public String things(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currUser = authentication.getName();
		if (currUser.equals("admin")) {
			model.addAttribute("things", repo.findAll());
		} else {
			model.addAttribute("things", repo.findByOwner(currUser));
		}

		return "things";
	}

	// CREATE avaa html-sivun addthing.html, joka löytyy
	// src/main/resources/templates kansiosta
	@RequestMapping(value = "/add")
	public String addThing(Model model) {
		model.addAttribute("thing", new Thing());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addthing";
	}

	// SAVE tallentaa thing olion ja palauttaa takaisin things listalle

	@PostMapping(value = "/add")
	public String save(@Valid Thing thing, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", categoryRepository.findAll());
			return "addthing";

		}
		model.addAttribute("owner", "admin");
		repo.save(thing);
		return "redirect:things";
	}

	// UPDATE päivittää listan thing olion ja palaa takaisin listaan

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editThing(@PathVariable("id") Long id, Model model) {
		model.addAttribute("thing", repo.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editthing";
	}

	// DELETE poistaa id:n mukaiasen thing olion. Huom näytetään vain, jos käyttäjän
	// rooli = ADMIN
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteThing(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);
		return "redirect:../things";
	}

}
