package com.springboot.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.model.dao.IUserDao;
import com.springboot.app.model.entities.User;
import com.springboot.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao userdao;
	

	@Override
	public String registerUser(String fullname, String email, String name, String password) {
		// TODO Auto-generated method stub
		if(userdao.existsByName(name)) {
			return "Nombre de usuario Existente";
		}else
		if(userdao.existsByEmail(email)){
			return "Email relacionado con otra cuenta";
		}else {
			
			User user=new User();
			user.setFullname(fullname);
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);
			userdao.save(user);
			return "Registro exitoso";
		}
		
		
	}

	@Override
	public String loginUser(String name, String password) {
		// TODO Auto-generated method stub
		Optional<User> opt=userdao.findByName(name);
		if(opt.isPresent()) {
			User user=opt.get();
			System.out.println("metodo"+user.getPassword());
			System.out.println("entrada"+password);
			if(user.getPassword().equals(password)) {
				return "Bienvenido";
			}else {
				return "Password incorrecto";
			}
		}else {
			return "El usuario no existe";
		}
		
	}
	@Override
	public String salir() {
		return "";
	}

	

}
