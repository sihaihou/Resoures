package com.reyco.core.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class DefaultExceptionHandler implements HandlerExceptionResolver {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		 //使用response返回 
		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType    
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		logger.error(ex.getMessage(),ex);
		try {
			response.getWriter().write("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		return mv;
	}
}
