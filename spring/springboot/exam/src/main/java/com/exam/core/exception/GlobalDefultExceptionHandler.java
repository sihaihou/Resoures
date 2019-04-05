package com.exam.core.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalDefultExceptionHandler {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	//声明要捕获的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ModelAndView defultExcepitonHandler(HttpServletRequest reuqest,HttpServletResponse response,Exception ex) {
		ex.printStackTrace();
		ModelAndView mv = new ModelAndView();
		response.setStatus(HttpStatus.OK.value()); //设置状态码  
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType  
        response.setCharacterEncoding("UTF-8"); //避免乱码  
        response.setHeader("Cache-Control", "no-cache, must-revalidate");  
        try {
        	if(ex instanceof BusinessException) {
    			BusinessException be = (BusinessException)ex;
    			logger.error("业务异常："+be.getMessage());
    			System.out.println("业务异常："+be.getMessage());
    			response.getWriter().write("{\"success\":false,\"msg\":\"" + "业务异常:"+be.getMessage() + "\"}");  
    		}
        	logger.error("系统异常：\\n"+ex.getMessage());
			response.getWriter().write("{\"success\":false,\"msg\":\"" + "系统异常"+ex.getMessage() + "\"}");  
        }catch (Exception e) {
        	System.out.println("业务异常："+ex.getMessage());
        	logger.error(e.getMessage(),e);
		}
		return mv;
	}
}
