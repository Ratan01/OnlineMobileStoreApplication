package com.cg.oma.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oma.respose.ResponseInfo;


@RestControllerAdvice
public class GlobalExceptionHandeler {

	// control all the method validation exception
	@ExceptionHandler(MethodArgumentNotValidException.class)     
	ResponseEntity<ResponseInfo> exceptionHandlingForValidation(MethodArgumentNotValidException e, HttpServletRequest request){
		Map<String, String> m=new LinkedHashMap<>(); 
		List<ObjectError> list=e.getBindingResult().getAllErrors ();
		list.forEach (obj->{
			FieldError fe= (FieldError)obj; 
			String fieldName=fe.getField();
			String errorMsg=fe.getDefaultMessage();
			m.put(fieldName, errorMsg);
		});
		ResponseInfo responseInfo=new ResponseInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),e.getMessage(),request.getRequestURI());
		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.NOT_FOUND);
		return responseEntity;
	}

	// control all the exception
	@ExceptionHandler(Exception.class)       
	ResponseEntity<ResponseInfo> exceptionHandlingForCustomer(Exception e, HttpServletRequest request){
		ResponseInfo responseInfo=new ResponseInfo(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.name(),e.getMessage(),request.getRequestURI());
		ResponseEntity<ResponseInfo> responseEntity=new ResponseEntity<>(responseInfo,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
}
