package com.example.demandeApi.security.springjwt.security.jwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.demandeApi.security.springjwt.dao.IDAO;
import com.example.demandeApi.security.springjwt.models.User;
import com.example.demandeApi.security.springjwt.repository.UserRepository;




@Service
public class UserService implements IDAO<User>{
	
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User o) {
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User o) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
