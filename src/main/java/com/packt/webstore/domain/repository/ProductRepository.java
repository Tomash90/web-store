package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
	public Product findByProductId(String ProductId);
	public List<Product> findAllByCategory(String category);
	public List<Product> findAllByManufacturer(String manufacturer);
}
