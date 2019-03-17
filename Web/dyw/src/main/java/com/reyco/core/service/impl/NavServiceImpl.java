package com.reyco.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.NavDao;
import com.reyco.core.pojo.Nav;
import com.reyco.core.service.NavService;

@Service("navService")
public class NavServiceImpl implements NavService{
	
	@Autowired
	private NavDao navDao;
	
	@Override
	public List<Nav> searchList() {
		return navDao.searchList();
	}

}
