package hs.dao.Impl;

import hs.dao.UserDao;

public class UserMySqLDaoImpl implements UserDao{
	@Override
	public void getUser() {
		System.out.println("MySqL获取数据");		
	}
}
