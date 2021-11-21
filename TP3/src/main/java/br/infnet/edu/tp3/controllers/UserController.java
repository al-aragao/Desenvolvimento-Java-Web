package br.infnet.edu.tp3.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.infnet.edu.tp3.domain.entities.User;
import br.infnet.edu.tp3.services.UserService;

@SessionAttributes("user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/User/SignUp")
	public String UserSignUp() {
		return "SignUp";
	}

	@PostMapping(value = "/User/SignUp")
	public String UserSignUpPost(Model model, User user, @RequestParam String confirmPassword) {

		List<String> errors = userService.add(user, confirmPassword);

		if (errors.size() > 0) {
			model.addAttribute("hasError", true);
		} else {
			model.addAttribute("hasError", false);
		}

		model.addAttribute("errors", errors);
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());

		return "SignUpConfirmation";
	}

	@PostMapping(value = "/User/SignIn")
	public String UserSignInPost(Model model, @RequestParam String email, @RequestParam String password) {

		User user = userService.getByLogin(email, password);
		
		if(user == null) {
			model.addAttribute("errorMessage", "Email or password are wrong");
			
			return "SignIn";
		}
		
		model.addAttribute("user", user);

		return "Index";
	}

	@GetMapping(value = "/User/SignOut")
	public String UserSignOut(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}
}
