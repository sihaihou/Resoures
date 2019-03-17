package com.reyco.core.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.reyco.core.pojo.Account;

public interface AccountService {
	/**
	 * login 登录
	 * @param phone
	 * @return
	 */
	public Account login(String phone);
	/**
	 * 注册用户
	 * @param vipId
	 * @param phone
	 * @param password
	 * @param name
	 * @param status
	 * @param desc
	 */
	public void register(String phone,String password,String name,Integer gender,String birthday,String email,Integer status,String desc);
	/**
	 *    上传使用
	 * @param phone
	 * @param password
	 * @param name
	 * @param gender
	 * @param birthday
	 * @param email
	 * @param status
	 * @param desc
	 */
	public void insert(Account account);
	/**
	 * 分页
	 * @param name
	 * @param phone
	 * @param status
	 * @param vipId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List<Account> searchPage(Integer pageNo,String name,String phone,Integer status,Integer vipId,String startTime,String endTime);
	/**
	 * 过滤用户名不能重复
	 * @param phone
	 * @return
	 */
	public boolean searchCountByPhone(String phone);
	
	/**
	 * 修改用户信息
	 * @param password
	 */
	public void updateAccount(Integer id,Integer integral,String phone,String name,String password,Integer status,Integer gender,String birthday,String email,String desc);
	/**
	 * 修改用户密码
	 * @param password
	 */
	public void updatePassword(Integer id,String password);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Account searchById(Integer id) ;
	/**
	 * 根据id，status查询Account
	 * @return
	 */
	public List<Account> searchList(Integer status,Integer vid);
	/**
	 * 根据vid、status查询导出用户
	 * @param status
	 * @param vid
	 * @return
	 */
	public Workbook exportAccount(Integer status,Integer vid) ;
	
}
