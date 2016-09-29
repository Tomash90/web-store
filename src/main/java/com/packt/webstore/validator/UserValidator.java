package com.packt.webstore.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public boolean supports(Class<?> arg0) {
		return UserDTO.class.isAssignableFrom(arg0);
	}

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
