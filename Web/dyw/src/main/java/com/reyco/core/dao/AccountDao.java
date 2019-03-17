package com.reyco.core.dao;

import java.util.List;
import java.util.Map;

import com.reyco.core.pojo.Account;

public interface AccountDao {
	/**
	 * login登录
	 * @param phone
	 * @return
	 */
	public Account login(String phone); 
	/**
	 * 注册用户
	 * 		---已弃用
	 * @param map
	 */
	@Deprecated
	public void register(Map<String,Object> map);
	/**
	 * 注册用户
	 * @param map
	 */
	public void register(Account account);
	/**
	 * 分页
	 * @param map
	 * @return
	 */
	public List<Account> searchPage(Map<String,Object> map);
	/**
	 * 过滤用户名不能重复
	 * @param phone
	 * @return
	 */
	public Integer searchCountByPhone(String phone);
	/**
	 * 修改用户信息
	 * 			---已弃用
	 * @param map
	 */
	@Deprecated
	public void updateAccount(Map<String,Object> map);
	/**
	 * 修改用户信息
	 * @param map
	 */
	public void updateAccount(Account account);
	
	public Account searchById(Integer id);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Account> searchList(Map<String,Object> map);
}
