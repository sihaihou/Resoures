package com.reyco.core.dao;

import com.reyco.core.pojo.Account;

public interface AccountDao {
	
	public Account searchUserByUserName(String username);
	
}
