package com.packt.webstore.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.DTO.UserDTO;

public class UserValidator implements Validator {

	@Autowired
	private javax.validation.Validator beanValidator;
	private Set<Validator> springValidators;
	
	public UserValidator() {
		springValidators = new HashSet<Validator>();
	}
	
	public void setSpringValidators(Set<Validator> springValidators) {
		this.springValidators = springValidators;
	}
	
	/**
	 * Check if UserDTO can be validate by validator
	 * @param clazz the Class that validator is being asked if it can validate
	 * @return false if validator can't validate UserDTO
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		return UserDTO.class.isAssignableFrom(arg0);
	}
	
	/**
	 * Validate UserDTO object 
	 * @param target UserDTO object that is to be validated
	 * @param errors state about validation
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);
		for(ConstraintViolation<Object> constraintViolation : constraintViolations) {
			String propertyPath = constraintViolation.getPropertyPath().toString();
			String message = constraintViolation.getMessage();
			errors.rejectValue(propertyPath, "", message);
		}
		for(Validator validator : springValidators){
			validator.validate(target, errors);
		}
		}
	}
