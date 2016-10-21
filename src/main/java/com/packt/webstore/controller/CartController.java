package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	
	@RequestMapping
	public String get(HttpServletRequest request) {
		HttpSession session = request.getSession(true);    
		session.setAttribute("username", request.getRemoteUser());
		String uname = (String) request.getSession(true).getAttribute("username");
		return "redirect:/cart/" + request.getSession(true).getId() +"/"+ uname ;
	}
	
	@RequestMapping(value= "/{cartId}/{username}", method= RequestMethod.GET) 
	public String getCart(@PathVariable(value = "cartId") String cartId, @PathVariable(value="username") String username, Model model) {
		model.addAttribute("cartId", cartId);
		model.addAttribute("username", username);
		return "cart";
	}
}
