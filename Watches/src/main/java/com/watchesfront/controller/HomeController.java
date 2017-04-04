package com.watchesfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//To display Home Page
	@RequestMapping("/Home")
	public String showHome()
	{
		return "Home";
	}
}
