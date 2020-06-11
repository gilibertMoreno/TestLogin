package com.springboot.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "login";
	}
	
	@GetMapping("/formRegister")
	public String register() {
		return "register";
	}

}
