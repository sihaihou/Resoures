package com.reyco.core.dao;

import java.util.List;

import com.reyco.core.pojo.Permission;

public interface PermissionDao {
	
	public List<Permission> searchPermissionByUserId(Integer id);
	
}
