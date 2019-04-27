package com.reyco.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {
	/**  
	 * �����쳣  
	 * @return  
	 * @throws Exception  
	 * String  
	 */    
	@RequestMapping(value = "/error_404", produces = "text/html;charset=UTF-8")    
	@ResponseBody    
	public String error_404() throws Exception {     
	     return "{\"msg\":\"�Ҳ���ҳ��\",\"code\":\"1000001\"}";    
	}    
	/**  
	 * �������쳣  
	 * @return  
	 * String  
	 */    
	@RequestMapping(value ="/error_500", produces = "text/html;charset=UTF-8")    
	public String error_500() {              
		return "{\"msg\":\"����������ʧ��\",\"code\":\"1000002\"}";    
	}    
}
