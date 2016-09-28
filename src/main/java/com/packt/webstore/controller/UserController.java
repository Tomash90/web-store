package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.domain.Users;
import com.packt.webstore.domain.DTO.UserDTO;
import com.packt.webstore.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/registration")
	public String addUser(HttpServletRequest request, @ModelAttribute("userDto") @Valid UserDTO userDto, BindingResult result) {
		if(request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
			Users user = new Users();
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			user.setEnabled(true);
			userService.save(user);
			return "redirect:/login";
		}
		return "registration";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
}
