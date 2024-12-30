package com.portal.dao;

import java.time.LocalDateTime;

public class ApiResponse {
	private String message;
	private LocalDateTime timeStamp;
	boolean status=false;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
		this.status=true;
	}

}
