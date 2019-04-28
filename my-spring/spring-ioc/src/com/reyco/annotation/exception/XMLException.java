package com.reyco.annotation.exception;

public class XMLException extends Exception {
	private String message;

	public XMLException(String message){
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
