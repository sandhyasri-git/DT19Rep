package com.niit.ecommercefrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommercebackend.dao.CartDAO;
import com.niit.ecommercebackend.dao.CartItemDAO;
import com.niit.ecommercebackend.model.Cart;

@Controller
public class CartController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	Cart cart;
	@Autowired
	CartItemDAO cartItemDAO;
	
	@RequestMapping("/cart")
	public String showCart()
	{
		return "Cart";
	}
	@RequestMapping("/allcartitems")
	public ModelAndView showCartItems()
	{
		ModelAndView mv=new ModelAndView("Cart");
		return mv;
	}
	@RequestMapping("/{id}/Cart")
	public String showDetails(@PathVariable Integer id, ModelMap model) {
		Cart cart=cartDAO.getCart(id);
		System.out.println(cart);
		System.out.println("inside cart");
		int x=cart.getUser().getUserid();
		model.addAttribute("mycartList",cartItemDAO.getAll(id) );
		return "Cart";
	}
}
