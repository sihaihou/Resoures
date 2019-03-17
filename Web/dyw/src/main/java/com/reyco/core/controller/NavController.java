package com.reyco.core.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.core.pojo.Nav;
import com.reyco.core.service.NavService;
import com.reyco.core.util.JSONResult;

@RequestMapping("/nav")
@Controller("navController")
public class NavController{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private NavService navService;
	
	@ResponseBody
	/*@RequestMapping(value= {"/searchList"} ,method= {RequestMethod.POST})*/
	@RequestMapping(value= {"/searchList"})
	public String searchList() throws InterruptedException {
		List<Nav> navList = navService.searchList();
		if(navList.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(navList).toJSON();
	}
	
	
}
