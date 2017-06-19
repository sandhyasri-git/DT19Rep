package com.niit.ecommercefrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ecommercebackend.dao.CartsDAO;
import com.niit.ecommercebackend.dao.ProductDAO;
import com.niit.ecommercebackend.model.Carts;
import com.niit.ecommercebackend.model.Product;

@Controller
public class CartsController {

	@Autowired
	private CartsDAO cartsDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("addtoCart/{userId}/{id}")
	public String addToCart(@PathVariable("id") int Productid, @PathVariable("userId") int userId,
			@RequestParam("quantity") int q, HttpSession session) throws Exception {
		System.out.println("inside carts controller");
		if (cartsDAO.getitem(Productid, userId) != null) {
			Carts item = cartsDAO.getitem(Productid, userId);
			item.setQuantity(item.getQuantity() + q);
			Product p = productDAO.get(item.getProductid());
			item.setPrice(item.getPrice() + (q * p.getProduct_price()));
			cartsDAO.saveOrUpdate(item);
			session.setAttribute("cartsize", cartsDAO.cartsize((Integer) session.getAttribute("userId")));
			return "redirect:/Carts";
		} else {
			Carts item = new Carts();
			Product product = productDAO.get(Productid);
			item.setProductname(product.getProduct_name());
			item.setUserid(userId);
			item.setQuantity(q);
			item.setPrice(q * product.getProduct_price());
			item.setStatus("C");
			item.setProductid(Productid);
			cartsDAO.saveOrUpdate(item);
			session.setAttribute("cartsize", cartsDAO.cartsize((Integer) session.getAttribute("userId")));
			return "redirect:/Carts";
		}

	}

	@RequestMapping("editorder/{cartid}")
	public String editorder(@PathVariable("cartid") int cartid, @RequestParam("quantity") int q, HttpSession session) {
		Carts cart = cartsDAO.getitem(cartid);
		Product p = productDAO.get(cart.getProductid());
		cart.setQuantity(q);
		cart.setPrice(q * p.getProduct_price());
		cartsDAO.saveOrUpdate(cart);
		session.setAttribute("cartsize", cartsDAO.cartsize((Integer) session.getAttribute("userId")));
		return "redirect:/viewcart";
	}

	@RequestMapping("deleteitem/{id}")
	public String deleteorder(@PathVariable("id") int id, HttpSession session) {
		cartsDAO.delete(id);
		session.setAttribute("cartsize", cartsDAO.cartsize((Integer) session.getAttribute("userId")));
		return "redirect:/viewcart";
	}

	@RequestMapping("viewcart")
	public String viewCart(Model model, HttpSession session) {
		int userId = (Integer) session.getAttribute("userId");
		model.addAttribute("CartList", cartsDAO.get(userId));
		model.addAttribute("CartPrice", cartsDAO.CartPrice(userId));
		model.addAttribute("IfViewCartClicked", "true");
		model.addAttribute("HideOthers", "true");
		return "Welcome";
	}

	@RequestMapping("placeorder")
	public String placeorder(Model model) {
		model.addAttribute("IfPaymentClicked", "true");
		model.addAttribute("HideOthers", "true");
		return "Welcome";
	}

	@RequestMapping("Payment")
	public String payment(HttpSession session) {
		cartsDAO.pay((Integer) session.getAttribute("userId"));
		return "redirect:/Welcome";
	}

}
