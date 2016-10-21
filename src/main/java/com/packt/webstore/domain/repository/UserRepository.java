package com.packt.webstore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
	public Users findByUserid(Integer userId);
	public Users findByUsername(String username);
}
