package hs.service;

public class UserServiceImpl implements UserService{
	@Override
	public void add() {
		System.out.println("添加数据");
	}
	@Override
	public void delete() {
		System.out.println("删除数据");
	}
	@Override
	public void update() {
		System.out.println("修改数据");
	}
	@Override
	public void search() {
		System.out.println("查询数据");
	}
}
