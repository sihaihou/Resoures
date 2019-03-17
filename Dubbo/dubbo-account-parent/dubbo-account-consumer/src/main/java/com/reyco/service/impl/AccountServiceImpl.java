package com.reyco.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.reyco.dubbo.domain.Account;
import com.reyco.dubbo.service.AccountDubboService;
import com.reyco.service.AccountService;
import com.reyco.util.FTPUtil;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	/**
	 * dubbo的注解，引人服务bean
	 */
	@Reference
	private AccountDubboService accountDubboService;
	
	@Override
	public List<Account> selectList() {
		return accountDubboService.selectList();
	}
	
	@Override
	public Boolean login(String name, String password) {
		return accountDubboService.login(name, password);
	}
	
	@Override
	public Boolean updatePath(String id, CommonsMultipartFile file){
		String filename = file.getOriginalFilename();
		String path = id+filename;
		try {
			Boolean flag = FTPUtil.uploadImage("test.jpg", file.getInputStream());
			if(flag) {
				return accountDubboService.updatePath(id, "images/"+path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
