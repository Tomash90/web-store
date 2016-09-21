package com.packt.webstore.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.DTO.ProductDTO;

@Component
public class UnitsInStockValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ProductDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDTO product = (ProductDTO) target;
		if(product.getUnitPrice() != null && new BigDecimal(10000).compareTo(product.getUnitPrice()) <= 0 && product.getUnitsInStock() > 99) {
			errors.rejectValue("unitsInStock", "com.packt.webstore.validator.UnitsInStockValidator.message");
		}
	}
	
}
