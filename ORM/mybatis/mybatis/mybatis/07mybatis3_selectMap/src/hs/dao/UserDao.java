package hs.dao;

import java.util.List;
import java.util.Map;

import hs.pojo.User;

public interface UserDao {
	
	List<User> selectUserByMap(Map<String,Object> map);
	
	List<User> selectUserByMap1(Map<String,Object> map);
	
	List<User> selectUserByContext(String name,int age);

}
