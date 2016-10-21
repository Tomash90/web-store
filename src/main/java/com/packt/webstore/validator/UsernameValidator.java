package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.packt.webstore.domain.Users;
import com.packt.webstore.service.UserService;

public class UsernameValidator implements ConstraintValidator<Username, String> {

	@Autowired
	UserService userService;
	
	@Override
	public void initialize(Username arg0) {
	}
	
	/**
	 * Check if given username exist in database
	 * @param value username to check
	 * @param context context in which the constraint is evaluated
	 * @return false if username doesn't exist in database
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Users user;
		user = userService.getUserByName(value);
		if(user != null) {
		return false;
		}
		return true;
	}

}
