package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.app.service.IUserService;

@Controller
public class RegisterController {

	@Autowired
	private IUserService userservice;
	
	@PostMapping ("/register")
	public String register(@RequestParam String fullname, @RequestParam String email, @RequestParam String name, @RequestParam String password,Model model) {
		String mesage=userservice.registerUser(fullname, email, name, password);
		if(mesage.equalsIgnoreCase("registro exitoso")) {
			model.addAttribute("success", mesage);
			return("login");
		}else {
			model.addAttribute("error", mesage);
			return("register");
		}
		
	}
	
	
}

