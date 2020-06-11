package com.springboot.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.app.model.dao.IUserDao;
import com.springboot.app.model.entities.User;

@Service
public class LoginUserImpl implements UserDetailsService {

	@Autowired
	private IUserDao userdao;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<User> opt = userdao.findByName(name);
			List<GrantedAuthority> roles=new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("ADMIN"));
			return new org.springframework.security.core.userdetails.User(name,opt.get().getPassword() , roles);

	}

}
