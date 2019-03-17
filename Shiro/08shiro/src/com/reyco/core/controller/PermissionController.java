package com.reyco.core.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.core.pojo.Permission;
import com.reyco.core.service.PermissionService;
import com.reyco.core.util.JSONResult;


@Controller("permissionController")
public class PermissionController{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PermissionService permissionService;
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	@ResponseBody
	@RequestMapping("list")
	public String list() {
		List<Permission> permissions = permissionService.searchPermissionByUserId(1);
		return JSONResult.create(permissions).toJSON();
	}
	
}