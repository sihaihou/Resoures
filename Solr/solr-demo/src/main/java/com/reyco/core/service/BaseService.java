package com.reyco.core.service;

import java.util.List;

import com.reyco.core.domain.Base;

public interface BaseService extends IBaseService<Base>{
	
	public List<Base> searchList(String name);
	
}
