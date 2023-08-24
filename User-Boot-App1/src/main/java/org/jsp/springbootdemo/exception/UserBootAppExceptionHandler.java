package org.jsp.springbootdemo.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.jsp.springbootdemo.dto.ResponseStructure;


import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class UserBootAppExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("User Not Found: ");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND); 
		
	}
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseStructure<String>> handleICE(InvalidCredentialsException exception){
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setData("User Not Found: ");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
}