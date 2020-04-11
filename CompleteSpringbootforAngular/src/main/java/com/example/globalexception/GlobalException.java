package com.example.globalexception;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.exceptions.IdAlreadyExistsException;
import com.example.exceptions.IdNotFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(IdNotFoundException.class) 
	public ResponseEntity<String> employeeNotFound(IdNotFoundException e){ 
		return new ResponseEntity<String>(e.getMessage(),new HttpHeaders(),HttpStatus.OK); 
	}
	@ExceptionHandler(IdAlreadyExistsException.class) 
	public ResponseEntity<String> IdAlreadyExists(IdAlreadyExistsException e){ 
		return new ResponseEntity<String>(e.getMessage(),new HttpHeaders(),HttpStatus.OK); 
	}
}