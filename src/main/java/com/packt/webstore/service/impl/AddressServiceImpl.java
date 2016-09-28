package com.packt.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Address;
import com.packt.webstore.domain.repository.AddressRepository;
import com.packt.webstore.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public Address getAddressByCustomerId(Integer customerId) {
		return addressRepository.findByCustomer(customerId);
	}
	public void saveAddress(Address address){
		addressRepository.save(address);
	}
	
}
