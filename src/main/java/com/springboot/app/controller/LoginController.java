package com.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	@PostMapping ("/login")
	public String login() {
			return "redirect:/home";
	}
	
	@GetMapping ("/login")
	public String loginError() {
			return "login";
	}
	
	@GetMapping ("/home")
	public String loginHome() {
			return "home";
	}
	
	@GetMapping("/logout")
	public String salir() {
		return "login";
	}

}
