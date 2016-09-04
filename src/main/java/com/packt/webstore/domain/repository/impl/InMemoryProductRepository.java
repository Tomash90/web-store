package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository(){
	Product diablo = new Product("D1234", "Diablo 3", new BigDecimal("49.99"));
	diablo.setDescription("Diablo III to trzecia część serii gier będących połączeniem akcji i cRPG.");
	diablo.setCategory("RPG");
	diablo.setManufacturer("Blizzard");
	diablo.setUnitsInStock(100);
	
	Product starcraftWol = new Product("D1235", "StarCraft II: Wings of Liberty", new BigDecimal("59.99"));
	starcraftWol.setDescription("StarCraft II: Wings of Liberty to pierwszy epizod kontynuacji jednej z najbardziej znanych strategii czasu rzeczywistego w historii gier komputerowych.");
	starcraftWol.setCategory("RTS");
	starcraftWol.setManufacturer("Blizzard");
	starcraftWol.setUnitsInStock(100);
	
	Product overwatch = new Product("D1236", "Overwatch", new BigDecimal("79.99"));
	overwatch.setDescription("Walcz na polach bitewnych przyszłości i wybierz swojego bohatera spośród plejady żołnierzy, naukowców, awanturników i odmieńców");
	overwatch.setCategory("FPS");
	overwatch.setManufacturer("Blizzard");
	overwatch.setUnitsInStock(100);
	
	listOfProducts.add(diablo);
	listOfProducts.add(starcraftWol);
	listOfProducts.add(overwatch);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	@Override
	public Product getProductById(String productId) {
		Product productById = null;
		for(Product product : listOfProducts){
			if(product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
			}
		}
			if(productById == null){
				throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
			}
		return productById;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		for(Product product : listOfProducts){
			if(product.getCategory().equalsIgnoreCase(category)){
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}

	@Override
	public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")){
			for(String brandName : filterParams.get("brand")){
				for(Product product : listOfProducts) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
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
	public List<Product> getProductByManufacturer(String manufacturer) {
		List<Product> productsByManufacturer = new ArrayList<Product>();
		for(Product product : listOfProducts){
			if(product.getManufacturer().equalsIgnoreCase(manufacturer)){
				productsByManufacturer.add(product);
			}
		}
		return productsByManufacturer;
	}

	@Override
	public Set<Product> getProductByPriceFilter(Map<String, List<String>> filterParams) {
		Set<String> criterias = filterParams.keySet();
		Set<Product> productsByLowPrice = new HashSet<Product>();
		Set<Product> productsByHighPrice = new HashSet<Product>();
		if(criterias.contains("low")){
			for(String price : filterParams.get("low")){
				BigDecimal bc = new BigDecimal(price);
				for	(Product product : listOfProducts){
					if(bc.compareTo(product.getUnitPrice()) == -1){
						productsByLowPrice.add(product);
					}
				}
				
			}
		}
		if(criterias.contains("high")){
			for(String price : filterParams.get("high")){
				for	(Product product : listOfProducts){
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
		listOfProducts.add(product);
	}

}
