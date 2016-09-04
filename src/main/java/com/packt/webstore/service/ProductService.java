package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public List<Product> getProductsByCategory(String category);
	public Set<Product> getProductsByFilter(Map <String, List<String>> filterParams);
	public Product getProductById(String id);
	public List<Product> getProductsByManufacturer(String manufacturer);
	public Set<Product> getProductsByPriceFilter(Map <String, List<String>> filterParams);
	public void addProduct(Product product);
}
