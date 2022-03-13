package com.cg.oma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oma.entities.Customer;
import com.cg.oma.exception.CustomerNotFoundException;
import com.cg.oma.respose.ResponseInfo;
import com.cg.oma.service.CustomerServiceImpl;
import com.cg.oma.utility.GlobalResources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;

	/**
	 * create a logger variable which is present in global utility package
	 */
	private Logger logger= GlobalResources.getLogger(CustomerController.class); 

	// for swagger show the details of method
	@Operation(summary="adding customer")

	/**
	 *Responses are grouped in five classes:
      Informational responses (100–199)
      Successful responses (200–299)
      Redirection messages (300–399)
      Client error responses (400–499)
      Server error responses (500–599)
	 */
	
	/**
	 * Api response for insert the customer
	 */
	@ApiResponses(value ={
			@ApiResponse(responseCode = "200", description = "successfully inserting the customer",
					content = {
							@Content (mediaType = "application/json",

									schema = @Schema(implementation = Customer.class)) }),

			@ApiResponse(responseCode = "404", description = "Error",
			content = {
					@Content(mediaType="application/json",
							schema=@Schema(implementation=ResponseInfo.class))}) })
	
	/**
	 *  end point and controller method to adding customer
	 */
	@PostMapping("/customers")
	ResponseEntity<ResponseInfo> addingCustomer(@Valid @RequestBody Customer name,HttpServletRequest request){
		String methodName="addingCustomer()";
		logger.info(methodName+"Called");

		String msg=customerService.addCustomer(name);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
		return rentity;
	}
	
	/**
	 * Api response for updating the customer
	 */
	@ApiResponses(value =
		{
				@ApiResponse(responseCode = "200", description = "Update the customer",
						content = {
								@Content (mediaType = "application/json",

										schema = @Schema(implementation = Customer.class)) }),

				@ApiResponse(responseCode = "400", description = "Invalid id supplied",
				content = {
						@Content(mediaType="application/json",
								schema=@Schema(implementation=ResponseInfo.class))}),
				@ApiResponse(responseCode = "404", description = "customer not found",
				content = @Content) })
	@Operation(summary="updating customer")
	
	/**
	 *  end point and controller method to updating the customer
	 */
	@PutMapping("/customers")
	ResponseEntity<ResponseInfo> updateCustomer(@Valid @RequestBody Customer name, HttpServletRequest request) throws CustomerNotFoundException{
		String methodName="updateCustomer()";
		logger.info(methodName+"Called");

		String msg=customerService.updateCustomer(name);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
	
	
	/**
	 * api response for deleting the customer
	 */
	
	@ApiResponses(value =
		{
				@ApiResponse(responseCode = "200", description = "deleted the customer",
						content = {
								@Content (mediaType = "application/json",

										schema = @Schema(implementation = Customer.class)) }),

				@ApiResponse(responseCode = "400", description = "Invalid id supplied",
				content = {
						@Content(mediaType="application/json",
								schema=@Schema(implementation=ResponseInfo.class))}),
				@ApiResponse(responseCode = "404", description = "customer not found",
				content = @Content) })
	
	/**
	 *  end point and controller method to deleting the customer
	 */
	@Operation(summary="deleting customer")
	@DeleteMapping("/customers/{id}")
	ResponseEntity<ResponseInfo> deleteCustomer(@Valid @PathVariable("id") int id, HttpServletRequest request)throws CustomerNotFoundException {
		String methodName="deleteCustomer()";
		logger.info(methodName+"Called");

		String msg=customerService.cancelCustomer(id);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
		return rentity;
	}
	
	/**
	 * Api response for showing the all customer
	 */
	
	@ApiResponses(value =
		{
				@ApiResponse(responseCode = "200", description = "Found the customer",
						content = {
								@Content (mediaType = "application/json",

										schema = @Schema(implementation = Customer.class)) }),

				@ApiResponse(responseCode = "400", description = "Invalid id supplied",
				content = {
						@Content(mediaType="application/json",
								schema=@Schema(implementation=ResponseInfo.class))}),
				@ApiResponse(responseCode = "404", description = "Customer not found",
				content = @Content) })
	
	/**
	 *  end point and controller method to show all the customer
	 */
	@Operation(summary="show all customer")
	@GetMapping("/customers")
	List<Customer> getAllCustomer(){
		String methodName="getAllCustomer()";
		logger.info(methodName+"Called");

		return customerService.showAllCustomer();
	}
}
