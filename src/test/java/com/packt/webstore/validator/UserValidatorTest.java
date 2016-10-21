package com.packt.webstore.validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import com.packt.webstore.domain.DTO.UserDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class UserValidatorTest {
	@Autowired
	private UserValidator uservalidator;
	@Test
	public void user_without_proper_password_should_be_invalid() {
		UserDTO user= new UserDTO();
		user.setUsername("test1@test.com");
		user.setPassword("Wasd");
		user.setConfirmPassword("Wasd");
		BindException bindException = new BindException(user, "user");
		ValidationUtils.invokeValidator(uservalidator, user, bindException);
		Assert.assertEquals(1, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Hasło musi zawierać pomiędzy 6 a 20 znaków, przynajmniej jedną dużą literę, jeden znak specjalny (@#$%) oraz jedną cyfrę"));
	}
	@Test
	public void username_with_existing_username_should_be_invalid() {
		UserDTO user = new UserDTO();
		user.setUsername("test@test.com");
		user.setPassword("Wasd$7");
		user.setConfirmPassword("Wasd$7");
		BindException bindException = new BindException(user, "user");
		ValidationUtils.invokeValidator(uservalidator, user, bindException);
		Assert.assertEquals(1, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Podany email już istnieje"));
	}
	@Test
	public void password_should_be_equal_confirmPassword() {
		UserDTO user = new UserDTO();
		user.setUsername("test1@test.com");
		user.setPassword("Wasd$7");
		user.setConfirmPassword("Wasd$7d");
		BindException bindException = new BindException(user, "user");
		ValidationUtils.invokeValidator(uservalidator, user, bindException);
		Assert.assertEquals(1, bindException.getErrorCount());
	}
}
