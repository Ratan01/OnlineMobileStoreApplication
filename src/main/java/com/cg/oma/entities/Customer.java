package com.cg.oma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Min(value=1, message="Customer Id can't be zero or negative")
	private int customerId;
	
	@NotNull(message="Customer Name must not be null")
	private String customerName;
	
	@NotNull(message="Customer password must not be null")
	private String customerPassword;
	
	@NotNull(message="Customer Mobile Number must not be null")
	private Long mobileNumber;
	
	@NotNull(message="CUstomer Email-id must not be null")
	private String emailId;
	
	//Parameterize constructor for customer 
	public Customer(@Min(value = 1, message = "Customer Id can't be zero or negative") int customerId,
			@NotNull(message = "Customer Name must not be null") String customerName,
			@NotNull(message = "Customer password must not be null") String customerPassword,
			@NotNull(message = "Customer Mobile Number must not be null") Long mobileNumber,
			@NotNull(message = "CUstomer Email-id must not be null") String emailId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	
	//default constructor 
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
