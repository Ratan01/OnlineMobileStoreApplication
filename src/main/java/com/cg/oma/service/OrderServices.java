package com.cg.oma.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oma.entities.Order;
import com.cg.oma.exception.OrderNotFoundException;
import com.cg.oma.repository.IOrderRepository;
import com.cg.oma.utility.GlobalResources;

@Transactional
@Service("orderServices")
public class OrderServices implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	//create logger variable which present in Globally resources package
	private Logger logger = GlobalResources.getLogger(OrderServices.class);
	
	/** Implemention of Adding the Order  */
	
	@Override
	public String addOrder(Order order) {
		
		String methodName = "addOrder()";
		logger.info(methodName + "Called");
		
		Order orderAdded = orderRepository.save(order);
		if (orderAdded != null) {
			return "Inserted successfully";
		} else
			return "There is a problem in insertion";

	}

	/** Implemention of Updating the Order  */
	
	@Override
	public String updateOrder(Order order) throws OrderNotFoundException {
		
		String methodName = "updateOrder()";
		logger.info(methodName + "Called");
		
		Order orderUpdated = orderRepository.save(order);
		if (orderUpdated != null) {
			return "Updated successfully";
		} else
			throw new OrderNotFoundException( "There is a problem in updation");
	}

	/** Implemention of Cancel the Order  */
	
	@Override
	public String cancelOrder(int id) throws OrderNotFoundException {
		
		String methodName = "cancelOrder()";
		logger.info(methodName + "Called");
		
		Optional<Order> op = orderRepository.findById(id);
		if (op.isPresent()) {
			orderRepository.deleteById(id);
			return ("Order delete successfully for this Id : " + " " + id);
		} else {
			throw new OrderNotFoundException("Order not found Plz Check Your ID");
		}
	}

	
}
