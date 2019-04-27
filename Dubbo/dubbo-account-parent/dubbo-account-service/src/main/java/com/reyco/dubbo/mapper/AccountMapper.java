package com.reyco.dubbo.mapper;

import java.util.List;
import java.util.Map;

import com.reyco.dubbo.domain.Account;

public interface AccountMapper {
	/**
	 * 查询列表
	 * @return
	 */
	//@Select("select * from account")
	List<Account> selectList();
	/**
	 * 登录
	 * @param name
	 * @param password
	 * @return
	 */
	//@Select("select id,name,password from account where name=#{name}")
	Account login(String name);
	/**
	 * 更新图片
	 * @param map
	 */
	void updatePath(Map<String,Object> map);
	
}
