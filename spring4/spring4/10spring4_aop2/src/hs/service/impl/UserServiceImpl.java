package hs.service.impl;

import hs.service.UserService;

public class UserServiceImpl implements UserService{
	@Override
	public void add() {
		System.out.println("添加数据");
	}
	@Override
	public void delete() {
		System.out.println("删除数据");
	}
}
