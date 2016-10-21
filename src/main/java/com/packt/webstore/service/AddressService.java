package com.packt.webstore.service;

import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Address;

@Service
public interface AddressService {
	public Address getAddressByCustomerId(Integer customerId);
	public void saveAddress(Address address);
}
