package com.reyco.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.reyco.core.dao.BaseDao;
import com.reyco.core.pojo.Base;
import com.reyco.core.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Base login(String name) {
		return baseDao.login(name);
	}
	
	@Override
	public List<Base> searchList(String name){
		Base base = new Base();
		base.setName(name);
		return baseDao.searchPage(base);
	}
	@Override
	public int searchCount(String name) {
		Base base = new Base();
		base.setName(name);
		return baseDao.searchCount(base);
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
	@Override
	public void batchInsert(List<Base> list) {
		baseDao.batchInsert(list);
	}
}
