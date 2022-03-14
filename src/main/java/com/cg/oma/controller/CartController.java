package com.cg.oma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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


import com.cg.oma.entities.Cart;
import com.cg.oma.entities.Mobile;
import com.cg.oma.exception.MobileNotFoundException;
import com.cg.oma.respose.ResponseInfo;
import com.cg.oma.service.ICartService;
import com.cg.oma.utility.GlobalResources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class CartController {
	@Autowired
	private ICartService service;

	private Logger logger= GlobalResources.getLogger(ICartService.class);

	@Operation(summary="adding mobiles in cart")
	@ApiResponses(value ={
			@ApiResponse(responseCode = "200", description = "successfully inserting the mobile",
					content = {
							@Content (mediaType = "application/json",

									schema = @Schema(implementation = Cart.class)) }),

			@ApiResponse(responseCode = "404", description = "Error",
			content = {
					@Content(mediaType="application/json",
							schema=@Schema(implementation=ResponseInfo.class))}) })
	@PostMapping("/carts")
	ResponseEntity<ResponseInfo> addMobileItems( @RequestBody List<Mobile> mobiles,HttpServletRequest request) {
		String methodName="addMobileItems()";
		logger.info(methodName + "Called");
		String msg=service.addMobileItems(mobiles);
		ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),null,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
		return rentity;
	}
	@Operation(summary="deleting mobile from cart")
	@ApiResponses(value ={
			@ApiResponse(responseCode = "200", description = "successfully deleting the mobile",
					content = {
							@Content (mediaType = "application/json",

									schema = @Schema(implementation = Cart.class)) }),

			@ApiResponse(responseCode = "404", description = "Error",
			content = {
					@Content(mediaType="application/json",
							schema=@Schema(implementation=ResponseInfo.class))}) })
	@DeleteMapping("/carts/{id}")
	ResponseEntity<ResponseInfo> deleteMobileItems(@PathVariable("id") @RequestBody int mobileId,HttpServletRequest request) throws MobileNotFoundException {
		String methodName="deleteMobileItems()";
		logger.info(methodName + "Called");
		String msg=service.deleteMobileItems(mobileId);
		ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),null,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
		return rentity;
	}
	@Operation(summary="updating mobiles in cart")
	@ApiResponses(value ={
			@ApiResponse(responseCode = "200", description = "successfully updating the cart",
					content = {
							@Content (mediaType = "application/json",

									schema = @Schema(implementation = Cart.class)) }),

			@ApiResponse(responseCode = "404", description = "Error",
			content = {
					@Content(mediaType="application/json",
							schema=@Schema(implementation=ResponseInfo.class))}) })
	@PutMapping("/carts/{id}")
	ResponseEntity<ResponseInfo> updateMobileItem(@RequestBody Mobile mobile,HttpServletRequest request) {
		String methodName="updateMobileItem()";
		logger.info(methodName + "Called");
		String msg=service.updateMobileItemquantity(mobile);
		ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),null,request.getRequestURI());
		ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
		return rentity;
	}
	@Operation(summary="showing all mobile in the cart")
	@ApiResponses(value ={
			@ApiResponse(responseCode = "200", description = "successfully showing in the cart",
					content = {
							@Content (mediaType = "application/json",

									schema = @Schema(implementation = Cart.class)) }),

			@ApiResponse(responseCode = "404", description = "Error",
			content = {
					@Content(mediaType="application/json",
							schema=@Schema(implementation=ResponseInfo.class))}) })
	@GetMapping("/carts")
	List<Mobile> showAllMobileItem() {
		String methodName="showAllMobileItem()";
		logger.info(methodName + "Called");
		return service.showAllMobileItems();
	}
	@Operation(summary="placing order from cart")
	@ApiResponses(value ={
			@ApiResponse(responseCode = "200", description = "successfully placing the order",
					content = {
							@Content (mediaType = "application/json",

									schema = @Schema(implementation = Cart.class)) }),

			@ApiResponse(responseCode = "404", description = "Error",
			content = {
					@Content(mediaType="application/json",
							schema=@Schema(implementation=ResponseInfo.class))}) })
	@GetMapping("/carts/placeOrders")
	long placeOrderFromCart(Cart cart) {
		String methodName="placeOrderFromCart()";
		logger.info(methodName + "Called");
		return service.placeOrder(cart);
	}
}
