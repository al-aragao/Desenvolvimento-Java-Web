package br.infnet.edu.tp3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.infnet.edu.tp3.domain.entities.User;

@Controller
public class SignInController {

	@GetMapping(value = "/")
	public String SignIn() {
		return "SignIn";
	}
}
