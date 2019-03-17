package com.reyco.core.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.core.pojo.SystemInfo;
import com.reyco.core.service.SystemInfoService;
import com.reyco.core.util.JSONResult;

@RequestMapping("/systemInfo")
@Controller("systemInfoController")
public class SystemInfoController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SystemInfoService systemInfoService;
	
	@ResponseBody
	@RequestMapping("/searchByInfoKey")
	public String searchByInfoKey(String infoKey) {
		if(StringUtils.isBlank(infoKey)) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_SELECT).toJSON();
		}
		String infoValue = systemInfoService.searchByInfoKey(infoKey);
		if(StringUtils.isBlank(infoValue)) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(infoValue).toJSON();
	}
	@ResponseBody
	@RequestMapping("/searchAll")
	public String searchAll() {
		List<SystemInfo> systemInfos = systemInfoService.searchAll();
		if(null == systemInfos) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(systemInfos).toJSON();
	}
	
	
	@ResponseBody
	@RequestMapping("/updateById")
	public String updateById(Integer id,String infoValue,Integer status,String desc) {
		if(id < 1 ) {
			return JSONResult.failCreate(JSONResult.UPDATE_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		systemInfoService.updateById(id, infoValue, status, desc);
		return JSONResult.create(JSONResult.UPDATE_SUCCESS).toJSON();
	}
	
	
	
	
}
