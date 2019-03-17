package com.reyco.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.SystemInfoDao;
import com.reyco.core.pojo.SystemInfo;
import com.reyco.core.service.SystemInfoService;

@Service("systemInfoService")
public class SystemInfoServiceImpl implements SystemInfoService {
	@Autowired
	private SystemInfoDao systemInfoDao;
	@Override
	public String searchByInfoKey(String infoKey) {
		return systemInfoDao.searchByInfoKey(infoKey);
	}
	@Override
	public void updateById(Integer id, String infoValue, Integer status, String desc) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("infoValue",infoValue);
		map.put("status", status);
		map.put("desc", desc);
		systemInfoDao.updateById(map);
	}
	@Override
	public List<SystemInfo> searchAll() {
		return systemInfoDao.searchAll();
	}

}
