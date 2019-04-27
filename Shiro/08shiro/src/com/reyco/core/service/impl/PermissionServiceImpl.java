package com.reyco.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.PermissionDao;
import com.reyco.core.pojo.Permission;
import com.reyco.core.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDao permissionDao;
	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}
	
	@Override
	public List<Permission> searchPermissionByUserId(Integer id) {
		return permissionDao.searchPermissionByUserId(id);
	}
}
