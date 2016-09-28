package com.packt.webstore.service;

import com.packt.webstore.domain.Customer;

public interface CustomerService {
	public void saveCustomer(Customer customer);
	public Customer getCustomer(Integer  customerId);
	public boolean isCustomerExist(String email);
	public Customer getCustomerByEmail(String email);
	public String getUserName(String name);
}
