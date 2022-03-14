package com.cg.oma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.oma.entities.Order;
import com.cg.oma.exception.OrderNotFoundException;
import com.cg.oma.respose.ResponseInfo;
import com.cg.oma.service.OrderServices;
import com.cg.oma.utility.GlobalResources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController

public class OrderController {

	@Autowired
	private OrderServices orderServices;
	
	//create logger variable which present in Globally resources package
	private Logger logger = GlobalResources.getLogger(OrderController.class);

		/**
		 * Responses are grouped in five classes:
		 
	       Informational responses (100–199)
		   Successful responses (200–299)
		   Redirection messages (300–399)
		   Client error responses (400–499)
		   Server error responses (500–599)
		**/
	
		/** ApiResponse for Adding the Order **/
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted successfully", 
			content = {
			@Content(mediaType = "application/json",

			schema = @Schema(implementation = Order.class)) }),

			@ApiResponse(responseCode = "400", description = "Invalid ", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "404", description = "Error", content = @Content) })

	//for Swagger shown the detail of method in Swagger
	@Operation(summary = "Insert the Order")
		
	/** This End point and Controller is used to Adding the Order **/
	
	@PostMapping("/orders")
	ResponseEntity<ResponseInfo> addingOrder(@Valid @RequestBody Order order, HttpServletRequest request) {
		
		//Logger Implemention
		String methodName = "addingOrder()";
		  logger.info(methodName + "Called");
		
		String message = orderServices.addOrder(order);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity = new ResponseEntity<>(rinfo, HttpStatus.CREATED);
		return rentity;
	}
	
	/** ApiResponse for Updating the Order **/
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated successfully", 
			content = {
			@Content(mediaType = "application/json",

			schema = @Schema(implementation = Order.class)) }),

			@ApiResponse(responseCode = "400", description = "Invalid", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "404", description = "Error", content = @Content) })

	//for Swagger shown the detail of method in Swagger
	@Operation(summary = "Update the Order")
	
	/** This End point and Controller is used to Update the Order **/
	
	@PutMapping("/orders")
	ResponseEntity<ResponseInfo> updatingOrder(@Valid @RequestBody Order order, HttpServletRequest request) throws OrderNotFoundException {

		//Logger Implemention
		String methodName = "updatingOrder()";
		logger.info(methodName + " Called");
		
		String message = orderServices.updateOrder(order);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity = new ResponseEntity<>(rinfo, HttpStatus.ACCEPTED);
		return rentity;
	}

	/** ApiResponse for cancel the Order **/
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Deleted successfully",
			content = {
			@Content(mediaType = "application/json",

			schema = @Schema(implementation = Order.class)) }),

			@ApiResponse(responseCode = "400", description = "Invalid", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
			@ApiResponse(responseCode = "404", description = "Error", content = @Content) })

	//for Swagger shown the detail of method in Swagger
	@Operation(summary = "Delete the Order")
	
	/** This End point and Controller is used to Cancel the Order **/
	
	@DeleteMapping("/orders/{id}")
	ResponseEntity<ResponseInfo> cancellingOrder(@Valid @PathVariable("id") int orderId, HttpServletRequest request) throws OrderNotFoundException {
		
		//Logger Implemention
		String methodName = "cancellingOrder()";
		logger.info(methodName + " Called");
		
		String message = orderServices.cancelOrder(orderId);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,	request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity = new ResponseEntity<>(rinfo, HttpStatus.ACCEPTED);
		return rentity;
	}
	
}
	

