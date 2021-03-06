package com.packt.webstore.controller;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Cart;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.DTO.ProductDTO;
import com.packt.webstore.domain.repository.CartRepository;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.validator.ProductIdValidator;
import com.packt.webstore.validator.ProductValidator;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;
	
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
		List<Product> products = productService.getProductsByCategory(category);
		if(products == null || products.isEmpty()){
			throw new NoProductsFoundUnderCategoryException();
		}
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
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addProductView(Model model){
		ProductDTO newProduct = new ProductDTO();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addNewProductForm(@ModelAttribute("newProduct") @Valid ProductDTO newProduct, BindingResult result, HttpServletRequest request){
		String[] suppressedFileds = result.getSuppressedFields();	
		if(result.hasErrors()){
			return "addProduct";
		}
		if(suppressedFileds.length > 0){
			throw new RuntimeException("Próba wiązania niedozwolonych pól:" + StringUtils.arrayToCommaDelimitedString(suppressedFileds));
		}
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory =request.getSession().getServletContext().getRealPath("/");
		if(productImage!=null && !productImage.isEmpty()){
			try {
				productImage.transferTo(new File(rootDirectory+"resources\\images\\"+newProduct.getProductId()+".jpg"));
			}
			catch(Exception e) {
				throw new RuntimeException("Zapis zdjęcia nie powiódł się", e);
			}
		}
		Product product = new Product(newProduct.getProductId(), newProduct.getName(), newProduct.getUnitPrice());
		product.setCategory(newProduct.getCategory());
		product.setCondition(newProduct.getCondition());
		product.setDescription(newProduct.getDescription());
		product.setManufacturer(newProduct.getManufacturer());
		product.setProductImage(newProduct.getProductImage());
		product.setUnitsInStock(newProduct.getUnitsInStock());
		productService.addProduct(product);
		return "redirect:/products";
	}
	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setAllowedFields("productId","name","unitPrice","description","manufacturer", "category", "unitsInStock","condition","productImage","language");
//		binder.setValidator(productValidator);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
}
