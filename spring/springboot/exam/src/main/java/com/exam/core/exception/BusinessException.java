package com.exam.core.exception;

import com.exam.core.domain.ResultEnum;

/**
 * 业务异常类
 * @author reyco
 *
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private Integer code;  //错误码
 
	public BusinessException() {
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
}
