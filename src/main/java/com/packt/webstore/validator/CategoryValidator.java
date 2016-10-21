package com.packt.webstore.validator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryValidator implements ConstraintValidator<Category, String> {

	private String[] allowedCategories;
	
	/**
	 * Initialize array of allowed categories
	 */
	@Override
	public void initialize(Category category) {
		allowedCategories = category.allowedCategories();
	}
	
	/**
	 * Check if allowed categories array contains given categories
	 * @param value categories to check
	 * @param context context in which the constraint is evaluated 
	 * @return false if given categories don't exist in array of allowed categories
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(Arrays.asList(allowedCategories).contains(value)) {
			return true;
		}
		return false;
	}

}
