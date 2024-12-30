package com.portal.exception;

public class ApiException extends RuntimeException {

	public ApiException(String mesg) {
		super(mesg);
	}
}