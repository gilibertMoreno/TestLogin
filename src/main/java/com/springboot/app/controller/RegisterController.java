package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.springboot.app.model.dao.IUserDao;
import com.springboot.app.service.IUserService;

@Controller
public class RegisterController {

	@Autowired
	private IUserService userservice;
	
	@GetMapping("/")
	public String index() {
		return "Registr";
	}
	
	@PostMapping ("/register")
	public String register(@RequestParam String fullname, @RequestParam String email, @RequestParam String name, @RequestParam String password,Model model) {
		String mesage=userservice.registerUser(fullname, email, name, password);
		if(mesage.equalsIgnoreCase("registro exitoso")) {
			model.addAttribute("Mesage", mesage);
			return("login");
		}else {
			model.addAttribute("Mesage", mesage);
			return("register");
		}
		
	}
	
	
}

