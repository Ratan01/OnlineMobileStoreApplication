package com.cg.oma.service;

import java.util.List;

import com.cg.oma.entities.Customer;
import com.cg.oma.exception.CustomerNotFoundException;

public interface ICustomerService {
	/**
	 *  all the method which we implement in servceImpl class
	 */
	public String addCustomer(Customer Customer);
	public String updateCustomer(Customer Customer) throws CustomerNotFoundException;
	public String cancelCustomer(int Customerid) throws CustomerNotFoundException;
	public List<Customer> showAllCustomer();
}

