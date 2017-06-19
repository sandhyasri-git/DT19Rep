package com.niit.ecommercebackend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="cart")
@Component
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartid;
	private int quantity;
	private double grandtotal;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private User user;
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="cart", fetch=FetchType.EAGER)
	private List<CartItem> cartitems = new ArrayList<CartItem>();
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}
	

}