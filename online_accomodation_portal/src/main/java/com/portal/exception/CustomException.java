package com.portal.exception;

public class CustomException  extends RuntimeException{
	
	private String errorMessage;
	
	public CustomException(String message )
	{
		this.errorMessage = message ;
	}

}
