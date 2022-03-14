package com.cg.oma.service;

import java.util.List;

import com.cg.oma.entities.Cart;
import com.cg.oma.entities.Mobile;
import com.cg.oma.exception.MobileNotFoundException;



public interface ICartService {
	public String addMobileItems(List<Mobile> mobiles);
	public String deleteMobileItems(int mobileId) throws MobileNotFoundException;
	public String updateMobileItemquantity(Mobile mobile);
	public List<Mobile> showAllMobileItems();
	public long placeOrder(Cart cart);
	
	
	/*
	public String addMobileItems(List<Mobile> mobiles);
	public String deleteCartItems(int id) throws MobileNotFoundException;
	public String updateCartItems(Cart cart);
	public Cart showAllMobileItems(int cartId);
	public int placeOrder(Cart cart);
	*/
}
