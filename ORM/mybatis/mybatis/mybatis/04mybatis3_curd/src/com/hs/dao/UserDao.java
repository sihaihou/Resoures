package com.hs.dao;

import java.util.List;
import java.util.Map;

import com.hs.pojo.User;

public interface UserDao {
	/**
	 * ��
	 * @param user
	 */
	public void insertUser(User user);
	public void insertUserCacheId(User user);
	/**
	 * ɾ��
	 * @param id
	 */
	public void deleteUserById(int id);
	/**
	 * �޸�
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * ��ѯ
	 * @return
	 */
	public List<User> selectAllUserList();
	public User selectUserById(int id);
	public List<User> selectUserByName(String name);
	public Map<String,Object> selectAllUserMap();

}
