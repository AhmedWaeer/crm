package com.ahmedwaeer.crmsystem.exceptions;

public class CustomerServiceException extends RuntimeException{

	private static final long serialVersionUID = 1276180196914763914L;
  
	public CustomerServiceException(String message) {
		
		super(message);
	}

}
