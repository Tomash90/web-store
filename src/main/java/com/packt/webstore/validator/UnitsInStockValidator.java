package com.packt.webstore.validator;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.DTO.ProductDTO;

@Component
public class UnitsInStockValidator implements Validator {

	/**
	 * Check if ProductDTO can be validate by validator
	 * @param clazz the Class that validator is being asked if it can validate
	 * @return false if validator can't validate ProductDTO
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDTO.class.isAssignableFrom(clazz);
	}

	/**
	 * Check if simultaneously given unit price isn't greater than 15 000 and units in stock are more than 50.
	 * @param target ProductDTO object that is to be validated
	 * @param errors state about validation
	 */
	@Override
	public void validate(Object target, Errors errors) {
		ProductDTO product = (ProductDTO) target;
		if(product.getUnitPrice() != null && new BigDecimal(15000).compareTo(product.getUnitPrice()) <= 0 && product.getUnitsInStock() > 50) {
			errors.rejectValue("unitsInStock", "com.packt.webstore.validator.UnitsInStockValidator.message");
		}
	}
	
}
