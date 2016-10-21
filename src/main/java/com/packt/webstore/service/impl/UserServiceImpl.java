package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Users;
import com.packt.webstore.domain.repository.UserRepository;
import com.packt.webstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public Users getUserById(Integer id) {
		return userRepository.findByUserid(id);
	}

	@Override
	public void save(Users user) {
		userRepository.save(user);
	}

	@Override
	public Users getUserByName(String name) {
		return userRepository.findByUsername(name);
	}
	
	
	
}
