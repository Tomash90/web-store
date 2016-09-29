package com.packt.webstore.service;

import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Users;

@Service
public interface UserService {
	public Users getUserById(Integer id);
	public void save(Users user);
	public Users getUserByName(String name);
}
