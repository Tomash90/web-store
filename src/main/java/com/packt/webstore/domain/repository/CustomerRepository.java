package com.packt.webstore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	public Customer findByCustomerId(Integer customerId);
	public Customer findByEmail(String email);
}
