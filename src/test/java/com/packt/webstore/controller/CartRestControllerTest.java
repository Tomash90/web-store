package com.packt.webstore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class CartRestControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void read_method_should_return_correct_cart_Json_object() throws Exception {
		this.mockMvc.perform(put("/rest/cart/add/D1238").session(session)).andExpect(status().is(204));
		
		this.mockMvc.perform(get("/rest/cart/" + session.getId()).session(session)).andExpect(status().isOk())
		.andExpect(jsonPath("$.cartItems.D1238.product.productId").value("D1238"));
		
	}
	
	@Test
	public void remove_method_should_remove_product_from_cart() throws Exception {
		this.mockMvc.perform(put("/rest/cart/add/D1238").session(session)).andExpect(status().is(204));
		
		this.mockMvc.perform(put("/rest/cart/remove/D1238").session(session)).andExpect(status().is(204));
	}
	
	@Test
	public void delete_cart_method() throws Exception {
		this.mockMvc.perform(put("/rest/cart/add/D1238").session(session)).andExpect(status().is(204));
		
		this.mockMvc.perform(delete("/rest/cart/" + session.getId()).session(session)).andExpect(status().is(204));
	}
	@Test
	public void post_cart_method() throws Exception {
		this.mockMvc.perform(post("/rest/cart").contentType(MediaType.APPLICATION_JSON).content("{\"cartId\":\"12345\"}")).andExpect(status().is(200))
		.andExpect(jsonPath("$.cartId").value("12345"));;
	}
	
}
