package com.cg.oma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.oma.entities.Customer;
import com.cg.oma.exception.CustomerNotFoundException;
import com.cg.oma.repository.ICustomerRepository;

class TestCustomerService {
	@Mock
	ICustomerRepository repository;
	@InjectMocks
	CustomerServiceImpl service;
	Customer customer;
	
	/**
	 * this method use inside every method first
	 */
	@BeforeEach
	public void testCommon() {
		MockitoAnnotations.initMocks(this);
		customer=new Customer(101, "Ratan", "Ah46", 999955656l, "rud@tagnk");
	}
	
	/**
	 * this method use for testing while adding customer
	 */
	@Test
	void testAddCustomer() {
		Mockito.when(repository.save(customer)).thenReturn(customer);
		//String actulResult=service.addCustomer(customer);
		String excpectedResult="Inserted Successfully!!";
		assertEquals(excpectedResult, service.addCustomer(customer));
		Mockito.verify(repository, Mockito.times(1)).save(customer);
	}
	/**
	 * this method use for testing while updating customer
	 */
	@Test
	void testUpdateCustomer() throws CustomerNotFoundException {
		Mockito.when(repository.save(customer)).thenReturn(customer);
		//String actulResult=service.updateCustomer(customer);
		String excpectedResult="Update Successfully!!";
		assertEquals(excpectedResult, service.updateCustomer(customer));
		Mockito.verify(repository, Mockito.times(1)).save(customer);
	}
	/**
	 * this method use for testing while canceling customer
	 */
	@Test
	void testCancelCustomer() throws CustomerNotFoundException {
		int id=101;
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(customer));
        String excpectedResult="Cancel Succesfully!!";
        //String actualResult=service.cancelCustomer(id);
        assertEquals(excpectedResult, service.cancelCustomer(id));
        Mockito.verify(repository, Mockito.times(1)).findById(id);
	}
	
	/**
	 * this method use for testing while  customer
	 */
	@Test
	void testshowAllCustomer() {
		List<Customer> list=new ArrayList<>();
		list.add(new Customer(101, "Ratan", "uh435", 877647645l, "rudra0092"));
		list.add(new Customer(102, "Rudra", "Ub96", 876654656l, "kumar@tagnk"));	
		
		Mockito.when(repository.findAll()).thenReturn(list);
        assertEquals(list, service.showAllCustomer());
        Mockito.verify(repository, Mockito.times(1)).findAll();
	}
	
	
	/*
	@Test
	void testCancelCustomerFailure() throws CustomerNotFoundException {
		int id= -23;
		Mockito.when(repository.findById(id)).thenThrow(Exception.class);
		assertThrows(CustomerNotFoundException.class, ()->service.cancelCustomer(id));
		Mockito.verify(repository.findById(id),Mockito.times(1));
	}
	*/
}