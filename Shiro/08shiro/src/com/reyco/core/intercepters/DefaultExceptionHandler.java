package com.reyco.core.intercepters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class DefaultExceptionHandler implements HandlerExceptionResolver {
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		/*  π”√response∑µªÿ */
		response.setStatus(HttpStatus.OK.value()); // …Ë÷√◊¥Ã¨¬Î
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); //…Ë÷√ContentType    
		response.setCharacterEncoding("UTF-8"); // ±‹√‚¬“¬Î
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		try {
			response.getWriter().write("{\"success\":false,\"msg\":\"" + ex.getMessage() + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mv;
	}
}
