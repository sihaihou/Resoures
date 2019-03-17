package com.reyco.core.dao;

import java.util.List;

import com.reyco.core.pojo.Nav;

public interface NavDao {
	/**
	 * nav列表
	 * @return
	 */
	public List<Nav> searchList();
	
}
