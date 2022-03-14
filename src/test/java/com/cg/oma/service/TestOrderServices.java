package com.cg.oma.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.oma.entities.Order;
import com.cg.oma.exception.OrderNotFoundException;
import com.cg.oma.repository.IOrderRepository;

class TestOrderServices {
	@Mock
	IOrderRepository ior;
	@InjectMocks
	OrderServices orderServices;

	Order order;
	
	
	
	@BeforeEach
	public void testCommon() {
		MockitoAnnotations.initMocks(this);
		order = new Order(101,LocalDate.of(2022,03,10),LocalDate.of(2022,03,15), 2, 20000, "Available");
	}

	/** 1. Test Case for Add Order */
	
	@Test
	void  testAddOrder(){
		Mockito.when(ior.save(order)).thenReturn(order);
		String expectedResult = "Inserted successfully";
		assertEquals(expectedResult, orderServices.addOrder(order));
	}
	
	/** 2. Test Case for Update Order */
	
	@Test
	void testUpdateOrder() throws OrderNotFoundException {
		Mockito.when(ior.save(order)).thenReturn(order);
		String expectedResult = "Updated successfully";
		assertEquals(expectedResult, orderServices.updateOrder(order));
	} 
	
	/** 3. Test Case for cancel Order */
	
	@Test
	void testCancelOrder() throws OrderNotFoundException {
		int id = 101;
		Mockito.when(ior.findById(id)).thenReturn(Optional.of(order));
		String expectedResult = "Order delete successfully for this Id : " + " " + id;
		assertEquals(expectedResult, orderServices.cancelOrder(id));
		 Mockito.verify(ior,Mockito.times(1)).findById(id);
	}
	
	/** 4. Test Case for cancel order in failure case  */
	
	@Test
	void testCancelOrderFailure() throws OrderNotFoundException {
		int id = -101;
		Mockito.when(ior.findById(id)).thenReturn(Optional.empty());
		assertThrows(OrderNotFoundException.class, () -> orderServices.cancelOrder(id));
		 Mockito.verify(ior,Mockito.times(1)).findById(id);
	}
	
}
