package com.packt.webstore.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.webstore.domain.DTO.UserDTO;

public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UserDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDto = (UserDTO) target;
		if(!userDto.getPassword().equals(userDto.getConfirmPassword())){
			errors.rejectValue("password", "com.packt.webstore.validator.PasswordValidator.message");
		}
	}
}
