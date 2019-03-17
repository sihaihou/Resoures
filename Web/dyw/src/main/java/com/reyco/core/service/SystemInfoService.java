package com.reyco.core.service;

import java.util.List;

import com.reyco.core.pojo.SystemInfo;

public interface SystemInfoService {
	public String searchByInfoKey(String infoKey);
	
	public List<SystemInfo> searchAll();
	
	public void updateById(Integer id,String infoValue,Integer status,String desc);
}
