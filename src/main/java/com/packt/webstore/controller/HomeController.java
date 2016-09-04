package com.packt.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String welcome(Model model){
		model.addAttribute("greeting", "Welcome to Our Store!");
		model.addAttribute("tagline", "Special and Smart Store");
		return "welcome";
	}
}
