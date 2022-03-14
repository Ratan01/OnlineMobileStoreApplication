package com.cg.oma.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oma.entities.Category;
import com.cg.oma.entities.Mobile;
import com.cg.oma.exception.MobileNotFoundException;
import com.cg.oma.respose.ResponseInfo;
import com.cg.oma.service.MobileServiceImpl;
import com.cg.oma.utility.GlobalResources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
public class MobileController {
	
	//create logger variable which present in Globally resources package
	
	private Logger logger= GlobalResources.getLogger(MobileController.class);
	
	@Autowired
	private MobileServiceImpl service;
	
	//for Swagger shown the detail of method in Swagger
	@Operation(summary="Insert Mobile")
	
	
	/**
	 *Responses are grouped in five classes:

				Informational responses (100–199)
				Successful responses (200–299)
				Redirection messages (300–399)
				Client error responses (400–499)
				Server error responses (500–599) 
	 *
	 */
	
	
	@ApiResponses(value = 
{
	  @ApiResponse(responseCode = "200", description = "insert successfully",
	    content = {
	    		@Content (mediaType = "application/json",
	    				
	      schema = @Schema(implementation = Mobile.class)) }),
	  
	  @ApiResponse(responseCode = "400", description = "invalid type",
	    content = {
	    		@Content(mediaType="application/json",
	    				schema=@Schema(implementation=Response.class))}),
	  @ApiResponse(responseCode = "404", description = "Error",
	    content = @Content) })
	
	/**
	     end point and controller method for insert mobile
	 */
	
	
	
	@PostMapping("/mobiles")
	 ResponseEntity<ResponseInfo> insertMobile(@Valid @RequestBody Mobile mobile,HttpServletRequest request)
    {
		//logger implementation
		String methodName="insertMobile()";
		logger.info(methodName + "called");
        String msg=service.addMobile(mobile);
        ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
        return rentity;
    }
	
	
	/**
    ApiResponse  for update mobile
    */
	
	
	@ApiResponses(value = 
		{
			  @ApiResponse(responseCode = "200", description = "success updating",
			    content = {
			    		@Content (mediaType = "application/json",
			    				
			      schema = @Schema(implementation = Mobile.class)) }),
			  
			  @ApiResponse(responseCode = "400", description = "Invalid",
			    content = {
			    		@Content(mediaType="application/json",
			    				schema=@Schema(implementation=Response.class))}),
			  @ApiResponse(responseCode = "404", description = "Error",
			    content = @Content) })
	
	
	
	/**
    end point and controller method for updating mobile
    */
	
	
	@Operation(summary="Updating Mobile")
	@PutMapping("/mobiles")
	 ResponseEntity<ResponseInfo> updatingMobile(@Valid @RequestBody Mobile mobile,HttpServletRequest request) throws MobileNotFoundException
	 
	{
		String methodName="updatingMobile()";
		logger.info(methodName + "called");
		String msg= service.updateMobile(mobile);
		ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),null,request.getRequestURI());
	     ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
	        return rentity;
	}
	
	/**
      ApiResponse for  Delete mobile
   */
	
	
	@ApiResponses(value = 
		{
			  @ApiResponse(responseCode = "200", description = "Deleting Mobile",
			    content = {
			    		@Content (mediaType = "application/json",
			    				
			      schema = @Schema(implementation = Mobile.class)) }),
			  
			  @ApiResponse(responseCode = "400", description = "Invalid id supplied",
			    content = {
			    		@Content(mediaType="application/json",
			    				schema=@Schema(implementation=Response.class))}),
			  @ApiResponse(responseCode = "404", description = "Mobile not found",
			    content = @Content) })
	
	
	
	
	/**
    end point and controller method for Delete mobile
    */
	
	@Operation(summary="Deleting Mobile")
	@DeleteMapping("/mobiles/{id}")
	 ResponseEntity<ResponseInfo> deletingMobile(@PathVariable("id")@RequestBody  int id ,HttpServletRequest request) throws MobileNotFoundException
	 
		{
		String methodName="deletingMobile()";
		logger.info(methodName + "called");
			String msg=service.deleteMobile(id);
			ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
		        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
		        return rentity;
		}
	
	
		
	/**
    ApiResponse for  Show All Mobile By CategoryId 
    */
	
	
	@ApiResponses(value = 
		{
			  @ApiResponse(responseCode = "200", description = "Found the Mobile",
			    content = {
			    		@Content (mediaType = "application/json",
			    				
			      schema = @Schema(implementation = Mobile.class)) }),
			  
			  @ApiResponse(responseCode = "400", description = "Invalid id supplied",
			    content = {
			    		@Content(mediaType="application/json",
			    				schema=@Schema(implementation=Response.class))}),
			  @ApiResponse(responseCode = "404", description = "movie not found",
			    content = @Content) })
	
	
	
	/**
    end point and controller method for Show All Mobile By Category Id  mobile
    */
	
	
	@Operation(summary="Show All Mobile By Category Id ")
	@GetMapping("/mobiles/byCategoryId/{categoryId}")
	List<Mobile> showMobileBycategory(@Valid @PathVariable("categoryId") int id){
		String methodName="showMobileBycategory()";
		logger.info(methodName + "called");
		return service.showAllMobileByCategoryId(id);
		
	}
	
	
	/**
    ApiResponse for  Show All Mobile By Id 
    */
	
	
	@ApiResponses(value = 
		{
			  @ApiResponse(responseCode = "200", description = "Found the mobile",
			    content = {
			    		@Content (mediaType = "application/json",
			    				
			      schema = @Schema(implementation = Mobile.class)) }),
			  
			  @ApiResponse(responseCode = "400", description = "Invalid id supplied",
			    content = {
			    		@Content(mediaType="application/json",
			    				schema=@Schema(implementation=Response.class))}),
			  @ApiResponse(responseCode = "404", description = "mobile not found",
			    content = @Content) })
	

	/**
    end point and controller method for Show All Mobile By  Id  
    */
	
	
	@Operation(summary="Show Mobile By MobileId ")
	@GetMapping("/mobiles/{mobileId}")
	Mobile allMobileById(@Valid @PathVariable("mobileId") int id) throws MobileNotFoundException  {
		String methodName="allMobileById()";
		logger.info(methodName + "called");
		return service.showMobileById(id);
		
	}
	

	/**
    end point and controller method for Add Category  
    */
	
	
	@Operation(summary="Add Category")
	@PostMapping("/categories")
	 ResponseEntity<ResponseInfo> addCategory(@RequestBody Category category, HttpServletRequest request){
		String methodName="addCategory()";
		logger.info(methodName + "called");
		String msg=service.addCategory(category);
		ResponseInfo info=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
        ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(info,HttpStatus.CREATED);
        return rentity;
	}
	
}
