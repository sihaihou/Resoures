package com.reyco.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.reyco.core.dao.VipDao;
import com.reyco.core.pojo.Vip;
import com.reyco.core.service.VipService;
import com.reyco.core.util.PageUtil;
@Service("vipService")
public class VipServiceImpl implements VipService {
	@Autowired
	private VipDao vipDao;
	
	@Override
	public List<Vip> searchList(Integer size) {
		return vipDao.searchList(size);
	}
	@Override
	public List<Vip> searchPage(Integer pageNo,String name) {
		PageHelper.startPage(pageNo,PageUtil.PAGESIZE);
		Vip vip = new Vip();
		vip.setName(name);
		return vipDao.searchPage(vip);
	}
	@Override
	public void insertVip(String name,Integer lowVip,Integer higVip,Integer status,String desc) {
		Vip vip = new Vip(name,lowVip,higVip,status,desc);
		vipDao.insertVip(vip);
	}
	@Override
	public Vip searchById(Integer id) {
		return vipDao.searchById(id);
	}
	@Override
	public void updateVip(Integer id, String name,Integer lowVip,Integer higVip,Integer status, String desc) {
		Vip vip = new Vip(id,name,lowVip,higVip,status,desc);
		vipDao.updateVip(vip);
	}

}
