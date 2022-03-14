package com.cg.oma.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oma.entities.User;
import com.cg.oma.exception.UserNotFoundException;
import com.cg.oma.respose.ResponseInfo;
import com.cg.oma.service.UserServiceImpl;
import com.cg.oma.utility.GlobalResources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;





@RestController
public class UserController {

	//create logger variable which present in Globally resources package
	@Autowired
	private UserServiceImpl userService;
	private Logger logger=GlobalResources.getLogger(UserServiceImpl.class);
    
	//for Swagger shown the detail of method in Swagger
	
	
	/**
	Responses are grouped in five classes: Informational responses (100–199)
	Successful responses (200–299)
	Redirection messages (300–399)
	Client error responses (400–499)
	Server error responses (500–599)
	*
	**/

	/*
	 * Api response for inserting  user
	 */

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted successfully",
			content = {
	@Content(mediaType = "application/json",

	schema = @Schema(implementation = User.class)) }),

	@ApiResponse(responseCode = "400", description = "Invalid ", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
	@ApiResponse(responseCode = "404", description = "Error", content = @Content) })
	
	/*
	 * End point and controller method for adding User 
	 */
	@PostMapping("/users")
	ResponseEntity<ResponseInfo> addingUser( @RequestBody User name,HttpServletRequest request){
		String methodName="addUser()";
		logger.info(methodName+"Called");
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String encodePwd=bcrypt.encode(name.getUserPassword());
		name.setUserPassword(encodePwd);
	String msg=userService.addUser(name);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.CREATED);
	return rentity;
	}
	/*
	 * Api response for updating  user
	 */

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted successfully",
			content = {
	@Content(mediaType = "application/json",

	schema = @Schema(implementation = User.class)) }),

	@ApiResponse(responseCode = "400", description = "Invalid ", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
	@ApiResponse(responseCode = "404", description = "Error", content = @Content) })
	
	/*
	 * End point and controller method for updating User 
	 */
	@PutMapping("/users")
	ResponseEntity<ResponseInfo> updateUser( @RequestBody User name, HttpServletRequest request){
		String methodName="updateUser()";
		logger.info(methodName+"Called");
	String msg=userService.updateUser(name);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	} 
	/*
	 * Api response for deleting  user
	 */

	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted successfully",
			content = {
	@Content(mediaType = "application/json",

	schema = @Schema(implementation = User.class)) }),

	@ApiResponse(responseCode = "400", description = "Invalid ", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
	@ApiResponse(responseCode = "404", description = "Error", content = @Content) })
	
	/*
	 * End point and controller method for deleting User 
	 */
	@DeleteMapping("/users/byUserName/{userName}")
	ResponseEntity<ResponseInfo> deleteUser( @PathVariable("userName") String userName, HttpServletRequest request) throws UserNotFoundException{
		String methodName="removeUser()";
		logger.info(methodName+"Called");
	String msg=userService.removeUser(userName);
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.ACCEPTED);
	return rentity;
	}
	
	/*
	 * Api response for showing  user
	 */

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted successfully",
			content = {
	@Content(mediaType = "application/json",

	schema = @Schema(implementation = User.class)) }),

	@ApiResponse(responseCode = "400", description = "Invalid ", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
	@ApiResponse(responseCode = "404", description = "Error", content = @Content) })
	/*
	 * End point and controller method for showing all User 
	 */
	@GetMapping("/users")
	List<User> getAllUser(){
		String methodName="showAllUser()";
		logger.info(methodName+"Called");
	return userService.showAllUsers();
	}
	/*
	 * Api response for validating  user
	 */

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Inserted successfully",
			content = {
	@Content(mediaType = "application/json",

	schema = @Schema(implementation = User.class)) }),

	@ApiResponse(responseCode = "400", description = "Invalid ", content = {
	@Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
	@ApiResponse(responseCode = "404", description = "Error", content = @Content) })
	/*
	 * End point and controller method for validating User 
	 */
	@GetMapping("/users/validate")
	ResponseEntity<ResponseInfo> validateUser(@RequestBody User user,HttpServletRequest request) throws UserNotFoundException{
		String methodName="validateUser()";
		logger.info(methodName+"Called");
		boolean b=userService.validateUser(user);
		String msg=null;
		if(b==true) {
			msg= "Authenticated User";
		}
		else 
			msg="not Authenticated User";
	
	ResponseInfo rinfo=new ResponseInfo(HttpStatus.OK.value(),HttpStatus.OK.name(),msg,request.getRequestURI());
	ResponseEntity<ResponseInfo> rentity=new ResponseEntity<>(rinfo,HttpStatus.OK);
	return rentity;
	}
}
