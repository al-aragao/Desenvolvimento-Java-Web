package br.infnet.edu.tp3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.infnet.edu.tp3.domain.entities.Opportunity;
import br.infnet.edu.tp3.domain.entities.User;
import br.infnet.edu.tp3.services.OpportunityService;

@Controller
public class OpportunityController {
	
	@Autowired
	private OpportunityService opportunityService;

	@GetMapping(value="Opportunity")
	public String OpportunityCreatePage() {				
		return "Opportunity";
	}

	@GetMapping(value="Opportunities")
	public String OpportunityMain(Model model, @SessionAttribute("user") User user) {
		
		model.addAttribute("opportunities", opportunityService.getAll(user.getId()));
		
		return "Opportunities";
	}

	@GetMapping(value="/Opportunity/{id}/Delete")
	public String OpportunityDelete(Model model, @PathVariable Integer id) {
		
		opportunityService.delete(id);
				
		return "redirect:/Opportunities";
	}
	
	@PostMapping(value="Opportunity")
	public String OpportunityCreate(Model model, Opportunity opportunity, @SessionAttribute("user") User user) {	
				
		opportunity.setUser(user);
		
		List<String> errors = opportunityService.add(opportunity);
		
		if(errors.size() > 0) {			
			model.addAttribute("errorMessages", errors);
			return "Opportunity";
		}
		
		model.addAttribute("name", opportunity.getName());
		return "redirect:Opportunities";
		
	}
}
