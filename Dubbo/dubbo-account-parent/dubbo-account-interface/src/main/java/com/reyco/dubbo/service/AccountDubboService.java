package com.reyco.dubbo.service;

import java.util.List;

import com.reyco.dubbo.domain.Account;

public interface AccountDubboService {
	/**
	 * 查询列表
	 * @return
	 */
	List<Account> selectList();
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	Boolean login(String name,String password);
	/**
	 * 上传
	 * @param id
	 * @param path
	 */
	Boolean updatePath(String id,String path);
	
}
