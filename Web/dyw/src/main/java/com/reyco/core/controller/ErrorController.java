package com.reyco.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.core.util.JSONResult;

@RequestMapping("/error")
@Controller
public class ErrorController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@ResponseBody
	@RequestMapping("/error")
	public String error() {
		Integer a =1/0;
		logger.info(a.toString());
		return JSONResult.create(a).toJSON();
	}
}
