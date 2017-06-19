package com.niit.ecommercebackend.dao;

import java.util.List;

import com.niit.ecommercebackend.model.Carts;

public interface CartsDAO {

	public List<Carts> list();

	public List<Carts> get(int userId);
	
	public Carts getitem(int cartId);

	public void saveOrUpdate(Carts cart);

	public void delete(int userId);
	
	public long CartPrice(int userId);	
	
	public Carts getitem(int prodId,int userId);
	
	public long cartsize(int userId);
	
	public void pay(int userId);

}
