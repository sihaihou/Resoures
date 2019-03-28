package hs.dao.Impl;

import hs.dao.UserDao;

public class UserOracleDaoImpl implements UserDao{
	@Override
	public void getUser() {
		System.out.println("Oracle获取数据");
	}
}
