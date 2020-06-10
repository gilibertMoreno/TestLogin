package com.springboot.app.service;

public interface IUserService {

	public String registerUser(String fullname,String email, String name, String password);
	public String loginUser(String name, String password);
	
}
