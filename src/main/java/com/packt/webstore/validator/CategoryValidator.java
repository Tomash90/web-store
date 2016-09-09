package com.packt.webstore.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {

	private String[] allowedCategories;
	
	@Override
	public void initialize(Category category) {
		allowedCategories = category.allowedCategories();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if(Arrays.asList(allowedCategories).contains(value)) {
			return true;
		}
		return false;
	}

}
