package com.packt.webstore.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getProductsByCategory(String category) {
		return productRepository.findAllByCategory(category);
	}

	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")){
			for(String brandName : filterParams.get("brand")){
				for(Product product : getAllProducts()) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		if(criterias.contains("category")){
			for(String category : filterParams.get("category")){
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
		
	}

	@Override
	public Product getProductById(String id) {
		if (productRepository.findByProductId(id) == null){
			throw new ProductNotFoundException(id);
		}
		return productRepository.findByProductId(id);
	}

	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return productRepository.findAllByManufacturer(manufacturer);
	}

	@Override
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		Set<String> criterias = filterParams.keySet();
		Set<Product> productsByLowPrice = new HashSet<Product>();
		Set<Product> productsByHighPrice = new HashSet<Product>();
		if(criterias.contains("low")){
			for(String price : filterParams.get("low")){
				BigDecimal bc = new BigDecimal(price);
				for	(Product product : getAllProducts()){
					if(bc.compareTo(product.getUnitPrice()) == -1){
						productsByLowPrice.add(product);
					}
				}
				
			}
		}
		if(criterias.contains("high")){
			for(String price : filterParams.get("high")){
				for	(Product product : getAllProducts()){
					BigDecimal bc = new BigDecimal(price);
					if(bc.compareTo(product.getUnitPrice()) == 1){
						productsByHighPrice.add(product);
					}
				}
				
			}
		}
		 productsByLowPrice.retainAll(productsByHighPrice);
		 return productsByLowPrice;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		Iterable<Product> source = productRepository.findAll();
		List<Product> target = new ArrayList<Product>();
		source.forEach(target::add);
		return target;
	}

}
