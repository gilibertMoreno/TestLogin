package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.app.service.IUserService;

@Controller
public class LoginController {
	
	@Autowired
	private IUserService userservice;
	
	@PostMapping ("/login")
	public String login(@RequestParam String  username, @RequestParam String password, Model model) {
		String mesage=userservice.loginUser(username, password);
		if(mesage.equalsIgnoreCase("Bienvenido")) {
			model.addAttribute("success", mesage);
			return "home";
		}else {
			model.addAttribute("error", mesage);
			return "login";
			
		}
		
	}

}
