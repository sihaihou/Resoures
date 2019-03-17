package com.reyco.core.dao;

import java.util.List;

import com.reyco.core.domain.Base;

public interface BaseDao extends IBaseDao<Base> {
	
	public List<Base> searchList(String name);
	
}
