package com.reyco.annotation.exception;
/**
 * PropertyXMLException异常
 * @author reyco
 *
 */
public class XMLPropertyException extends Exception {
	private String Message="value and ref 不能同时为null";
	
	public XMLPropertyException() {
		super();
	}
	public XMLPropertyException(String message) {
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
