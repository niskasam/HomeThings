package fi.niskasam.HomeThings.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.niskasam.HomeThings.domain.Register;
import fi.niskasam.HomeThings.domain.User;
import fi.niskasam.HomeThings.domain.UserRepository;

@Controller
public class UserController {

	 @Autowired
	 private UserRepository UserRepo; 
	
	 @RequestMapping(value = "register")
	    public String registerNewUser(Model model){
	    	model.addAttribute("register", new Register());
	        return "register";
	    }	
	 
	 @RequestMapping(value = "saveuser", method = RequestMethod.POST)
	    public String save(@Valid @ModelAttribute("register") Register register, BindingResult bindingResult) {
	    	if (!bindingResult.hasErrors()) { // validation errors
	    		if (register.getPassword().equals(register.getPasswordCheck())) { // check password match		
		    		String pwd = register.getPassword();
			    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			    	String hashPwd = bc.encode(pwd);
		
			    	User newUser = new User();
			    	newUser.setPasswordHash(hashPwd);
			    	newUser.setUsername(register.getUsername());
			    	newUser.setRole("USER");
			    	if (UserRepo.findByUsername(register.getUsername()) == null) { // Check if user exists
			    		UserRepo.save(newUser);
			    	}
			    	else {
		    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
		    			return "register";		    		
			    	}
	    		}
	    		else {
	    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
	    			return "register";
	    		}
	    	}
	    	else {
	    		return "register";
	    	}
	    	return "redirect:/login";    	
	    }    
}
