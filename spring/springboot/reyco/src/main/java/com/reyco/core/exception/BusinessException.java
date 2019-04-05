package com.reyco.core.exception;

import com.reyco.core.domain.ResultEnum;

/**
 * 业务异常类
 * @author reyco
 *
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private Integer code;  //错误码
	private String message;
 
	public BusinessException() {
	}
	public BusinessException(String message) {
		super();
		this.message = message;
	}
	public BusinessException(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public BusinessException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
