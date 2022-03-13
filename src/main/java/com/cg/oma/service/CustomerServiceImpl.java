package com.cg.oma.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oma.controller.CustomerController;
import com.cg.oma.entities.Customer;
import com.cg.oma.exception.CustomerNotFoundException;
import com.cg.oma.repository.ICustomerRepository;
import com.cg.oma.utility.GlobalResources;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerRepository customerRepository;
	
	
	/**
	 *  Logger is present in the global utility package
	 */
	private Logger logger= GlobalResources.getLogger(CustomerController.class); 
	
	
	/**
	 *  Implementation of add customer in this method
	 */
	@Override
	public String addCustomer(Customer Customer) {
		String methodName="addCustomer()";
		logger.info(methodName + "Called");
		
		customerRepository.save(Customer);
		return "Inserted Successfully!!";
	}
	
	/**
	 *  Implementation of update customer in this method
	 */
	@Override
	public String updateCustomer(Customer Customer) throws CustomerNotFoundException {
		String methodName="updateCustomer()";
		logger.info(methodName+"Called");
		
		customerRepository.save(Customer);
		return "Update Successfully!!";
	}
	
	/**
	 *  Implementation of cancel customer in this method
	 */
	@Override
	public String cancelCustomer(int id) throws CustomerNotFoundException {
		String methodName="cancelCustomer()";
		logger.info(methodName+"Called");
		
		Optional<Customer> op=customerRepository.findById(id);
		if(op.isPresent()) {
			customerRepository.deleteById(id);
			return "Cancel Succesfully!!";
		}
		else
			 throw new CustomerNotFoundException("No Customer found for this id: "+id);
	} 
	
	/**
	 *  Implementation of show all customer in this method
	 */
	@Override
	public List<Customer> showAllCustomer() { 
		String methodName="showAllCustomer()";
		logger.info(methodName+"Called");
		
		return customerRepository.findAll();
	}	
}
