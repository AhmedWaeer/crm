package com.ahmedwaeer.crmsystem.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ahmedwaeer.crmsystem.ui.model.response.ErrorMessage;

@ControllerAdvice
public class SystemExceptionHandler {
	
	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<Object> handleCustomerServiceException(CustomerServiceException ex, WebRequest req){
		
		
		ErrorMessage errormessage = new ErrorMessage(new Date(), ex.getMessage());
		
		return new ResponseEntity<>(errormessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest req){
		
		
		ErrorMessage errormessage = new ErrorMessage(new Date(), ex.getMessage());
		
		return new ResponseEntity<>(errormessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
