package com.reyco.core.service;

import java.util.List;

import com.reyco.core.pojo.Permission;

public interface PermissionService {
	
	public List<Permission> searchPermissionByUserId(Integer id);
	
}
