package com.packt.webstore.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
	public Address findByCustomer(Integer customerId);
}
