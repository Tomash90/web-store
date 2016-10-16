package com.packt.webstore.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.DTO.ProductDTO;

import java.math.BigDecimal;

import org.junit.Assert;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class ProductValidatorTest {

	@Autowired
	private ProductValidator productValidator;
	
	@Test
	public void product_without_UnitPrice_should_be_invalid() {
		ProductDTO product = new ProductDTO();
		BindException bindException = new BindException(product,"product");
		
		ValidationUtils.invokeValidator(productValidator, product, bindException);
		
		Assert.assertEquals(3, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Błędna cena produktu. Pole cena nie może być puste."));
	}
	
	@Test
	public void product_with_existing_productId_invalid() {
		ProductDTO gta = new ProductDTO("D1237","GTA V", new BigDecimal(100));
		gta.setCategory("RTS");
		BindException bindException = new BindException(gta,"product");
		
		ValidationUtils.invokeValidator(productValidator, gta, bindException);
		
		Assert.assertEquals(1, bindException.getErrorCount());
		Assert.assertTrue(bindException.getLocalizedMessage().contains("Produkt o wskazanym ID juz istnieje"));
	}
	
	@Test
	public void a_valid_product_should_not_get_any_error_during_validation() {
		ProductDTO test1 = new ProductDTO("D1231","test1", new BigDecimal(50));
		test1.setCategory("RTS");
		
		BindException bindException = new BindException(test1,"product");
		
		ValidationUtils.invokeValidator(productValidator, test1, bindException);
		
		Assert.assertEquals(0, bindException.getErrorCount());
	}
}
