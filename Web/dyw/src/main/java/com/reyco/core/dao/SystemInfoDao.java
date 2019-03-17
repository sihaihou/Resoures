package com.reyco.core.dao;

import java.util.List;
import java.util.Map;

import com.reyco.core.pojo.SystemInfo;

public interface SystemInfoDao {
	
	public String searchByInfoKey(String infoKey);
	
	public List<SystemInfo> searchAll();
	
	public void updateById(Map<String,Object> map);
}
