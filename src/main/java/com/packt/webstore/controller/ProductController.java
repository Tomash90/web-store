package com.packt.webstore.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String list (Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/all")
	public String allProducts(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String category) {
		model.addAttribute("products", productService.getProductsByCategory(category));
		return "products";
	}
	
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar= "ByCriteria") Map<String, List<String>> filterParams, Model model){
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProductById(@RequestParam("id") String productId, Model model){
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping("/{category}/{price}")
	public String filterProducts(@RequestParam("manufacturer") String manufacturer, @MatrixVariable(pathVar= "price") Map<String, List<String>> filterParams,@PathVariable("category") String category, Model model){
		List<Product> manuf = productService.getProductsByManufacturer(manufacturer);
		List<Product> cat = productService.getProductsByCategory(category);
		Set<Product> price = productService.getProductsByPriceFilter(filterParams);
		Set<Product> all = new HashSet<Product>();
		all.addAll(price);
		all.retainAll(cat);
		all.retainAll(manuf);
		model.addAttribute("products", all);
		return "products";
	}
}
