package com.hs.dao;

import java.util.List;
import java.util.Map;

import com.hs.pojo.User;

public interface UserDao {
	/**
	 * Ôö
	 * @param user
	 */
	public void insertUser(User user);
	public void insertUserCacheId(User user);
	/**
	 * É¾³ý
	 * @param id
	 */
	public void deleteUserById(int id);
	/**
	 * ÐÞ¸Ä
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * ²éÑ¯
	 * @return
	 */
	public List<User> selectAllUserList();
	public User selectUserById(int id);
	public List<User> selectUserByName(String name);
	public Map<String,Object> selectAllUserMap();

}
