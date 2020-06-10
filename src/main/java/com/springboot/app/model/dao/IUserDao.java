package com.springboot.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.model.entities.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer>{
	public boolean existsByName(String name);
	public boolean existsByEmail(String email);

}
