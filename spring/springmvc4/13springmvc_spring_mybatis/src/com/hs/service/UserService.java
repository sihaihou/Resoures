package com.hs.service;

import java.util.List;

import com.hs.pojo.User;

public interface UserService {
	public List<User> getAll();
	public int delete(int id);
}
