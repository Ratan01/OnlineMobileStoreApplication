package com.cg.oma.exception;

public class CustomerNotFoundException extends Exception {
	
	//method of exception for customer not found
	public CustomerNotFoundException(String message) {
		super(message);
	}
}
