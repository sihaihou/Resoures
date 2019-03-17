package com.reyco.service;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.reyco.dubbo.domain.Account;

public interface AccountService {
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
	 * 更新图片
	 * @param id
	 * @param file
	 * @return
	 */
	Boolean updatePath(String id,CommonsMultipartFile file);
	
}
