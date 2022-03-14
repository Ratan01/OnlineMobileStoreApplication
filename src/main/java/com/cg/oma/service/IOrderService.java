package com.cg.oma.service;

import java.util.List;


import com.cg.oma.entities.Order;
import com.cg.oma.exception.OrderNotFoundException;

public interface IOrderService {
	
	public String addOrder(Order order);
	public String updateOrder(Order order) throws OrderNotFoundException;
	public String cancelOrder(int id) throws OrderNotFoundException;
	
}
