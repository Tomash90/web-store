package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Users;
import com.packt.webstore.domain.DTO.UserDTO;
import com.packt.webstore.service.UserService;
import com.packt.webstore.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("userDto") @Valid UserDTO userDto, BindingResult result) {
		if(result.hasErrors()){
			return "registration";
		}
		else {
			Users user = new Users();
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			user.setEnabled(true);
			userService.save(user);
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String addRegistrationView(Model model) {
		UserDTO userDto = new UserDTO();
		model.addAttribute("userDto", userDto);
		return "registration";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setValidator(userValidator);
	}
	
}
