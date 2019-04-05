package com.sxt.utils;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
	private static final long serialVersionUID = -8134313953478922076L;
	private Long id;
	private String message;
	@Override
	public String toString() {
		return "ResponseMessage [id=" + id + ", message=" + message + "]";
	}
	public ResponseMessage() {
		super();
	}
	public ResponseMessage(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
