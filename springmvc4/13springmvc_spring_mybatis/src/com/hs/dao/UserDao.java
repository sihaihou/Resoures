package com.hs.dao;

import java.util.List;

import com.hs.pojo.User;

public interface UserDao {
	public List<User> getAll();
	public int delete(int id);
}
