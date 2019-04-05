package hs.dao;

import java.util.List;
import java.util.Map;

import hs.pojo.User;

public interface UserDao {
	//Ôö
	void insertUser(User user);
	//É¾³ý
	void deleteUserById(int id);
	//ÐÞ¸Ä
	void updateUser(User user);
	//²éÑ¯
	List<User> selectAllUserList();
	User selectUserById(int id);
	List<User> selectUserByName(String name);

}
