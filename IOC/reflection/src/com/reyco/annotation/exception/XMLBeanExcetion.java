package com.reyco.annotation.exception;

public class XMLBeanExcetion extends Exception {
	private String Message;

	public XMLBeanExcetion(String message) {
		super();
		Message = message;
	}
	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
}
