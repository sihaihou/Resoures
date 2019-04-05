package com.reyco.core.springmvc.service.impl;

import com.reyco.core.springmvc.annotation.Service;
import com.reyco.core.springmvc.entity.Base;
import com.reyco.core.springmvc.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {

	public Base getBase(String name,String password) {
		Base base = new Base(name,password);
		return base;
	}

}
