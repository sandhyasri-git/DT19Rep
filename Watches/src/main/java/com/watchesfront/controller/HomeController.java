package com.watchesfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	//To display Home Page
	@RequestMapping("/Home")
	public String showHome()
	{
		return "Home";
	}
	//To display Login Page
	@RequestMapping("/login")
	public String showLogin()
	{
		return "NewFile";
	}
	@RequestMapping("/validate")
	public ModelAndView showMessage(@RequestParam("username")String uname,@RequestParam("password")String pass)
	{
		ModelAndView mv;
		if(uname.equals("NIIT")&&pass.equals("NIIT"))
		{
			mv=new ModelAndView("Home");
			mv.addObject("loggedInUser", "User");
			return mv;
		}
		else
		{
			mv=new ModelAndView("Login");
			return mv;
		}
	}
	@RequestMapping("/logout")
	public ModelAndView showLogout()
	{
		ModelAndView mv;
			mv=new ModelAndView("logout");
			mv.addObject("loggedout", "User");
			return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView showSignUp()
	{
		ModelAndView mv;
			mv=new ModelAndView("NewFile1");
			return mv;
	}
	
@RequestMapping("/register")
public ModelAndView showRegister(@RequestParam("password")String pass,@RequestParam("cpass")String cpass)
{
	ModelAndView mv;
	if(pass.equals(cpass))
	{
		mv=new ModelAndView("Login");
		mv.addObject("loggedInUser", "User");
		return mv;
	}
	else
	{
		mv=new ModelAndView("signup");
		return mv;
	}
}

}