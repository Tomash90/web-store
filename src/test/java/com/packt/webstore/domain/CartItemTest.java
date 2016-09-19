package com.packt.webstore.domain;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class CartItemTest {
	private CartItem cartItem1;
	private CartItem cartItem2;
	private Cart cart;
	private Product gta;
	private Product test1;
	
	@Before
	public void setup() {
		cartItem1 = new CartItem();
		cartItem2 = new CartItem();
		cart = new Cart();
		gta = new Product("D1238","GTA V", new BigDecimal(100));
		test1 = new Product("D1237","test1", new BigDecimal(50));
		cartItem1.setProduct(gta);
		cartItem2.setProduct(test1);
		cart.addCartItem(cartItem1);
		cart.addCartItem(cartItem2);
		cart.addCartItem(cartItem2);
	}
	@Test
	public void cartItem_total_price_should_be_equal_to_unit_price_in_case_of_single_quantity() {
		BigDecimal totalPrice = cartItem1.getTotalPrice();
		Assert.assertEquals(gta.getUnitPrice(), totalPrice);
	}
	
	@Test
	public void cart_grand_total_price_should_be_equal_sum_of_unit_prices_products_added_to_cart() {
		BigDecimal grandTotal = cartItem1.getTotalPrice().add(cartItem2.getTotalPrice());
		Assert.assertEquals(cart.getGrandTotal(), grandTotal);
	}
	
	@Test
	public void removeItemFromCart() {
		cart.removeCartItem(cartItem1);
		BigDecimal grandTotal = cartItem2.getTotalPrice();
		Assert.assertEquals(cart.getGrandTotal(), grandTotal);
	}
}
