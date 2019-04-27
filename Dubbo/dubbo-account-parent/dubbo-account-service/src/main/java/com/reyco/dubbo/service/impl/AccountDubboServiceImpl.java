package com.reyco.dubbo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.reyco.dubbo.domain.Account;
import com.reyco.dubbo.mapper.AccountMapper;
import com.reyco.dubbo.service.AccountDubboService;

public class AccountDubboServiceImpl implements AccountDubboService{
	
	@Autowired
	private AccountMapper accountDao;
	
	@Override
	public List<Account> selectList() {
		return accountDao.selectList();
	}

	@Override
	public Boolean login(String name, String password) {
		Account account = accountDao.login(name);
		if(null == account) {
			return false;
		}
		if(!account.getPassword().equals(password)) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean updatePath(String id, String path) {
		if(null == id || null == path) {
			return false;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("path", path);
		accountDao.updatePath(map);
		return true;
	}
	
}
