package com.reyco.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.reyco.core.dao.BaseDao;
import com.reyco.core.domain.Base;
import com.reyco.core.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<Base> searchList(String name){
		return baseDao.searchList(name);
	}

	@Override
	public void insert(Base t) {
		baseDao.insert(t);
	}

	@Override
	public Base searchById(Integer id) {
		return baseDao.searchById(id);
	}

	@Override
	public void updateById(Base base) {
		baseDao.updateById(base);
	}

	@Override
	public PageInfo<Base> searchPage(Base t) {
		List<Base> list = baseDao.searchPage(t);
		return new PageInfo<Base>(list);
	}
		
}
