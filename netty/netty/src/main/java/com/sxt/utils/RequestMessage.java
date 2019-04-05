package com.sxt.utils;

import java.io.Serializable;

public class RequestMessage implements Serializable {
	private static final long serialVersionUID = 7084843947860990140L;
	private Long id;
	private String message;
	private byte[] attachment;
	@Override
	public String toString() {
		return "RequestMessage [id=" + id + ", message=" + message + "]";
	}
	public RequestMessage() {
		super();
	}
	public RequestMessage(Long id, String message, byte[] attachment) {
		super();
		this.id = id;
		this.message = message;
		this.attachment = attachment;
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
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
}
