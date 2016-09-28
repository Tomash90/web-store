package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomer(Integer customerId) {
		return customerRepository.findByCustomerId(customerId);
	}

	@Override
	public boolean isCustomerExist(String email) {
	Customer customer = getCustomerByEmail(email);
		if(customer != null) {
			return true;
		}
			return false;
	}

	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	public String getUserName(String name) {
		return name;
	}
}
