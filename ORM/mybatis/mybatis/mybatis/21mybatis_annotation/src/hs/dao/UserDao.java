package hs.dao;

import org.apache.ibatis.annotations.Select;

import hs.pojo.User;

public interface UserDao {
	@Select("select * from user where id=#{id}")
	public User selectUserById(int id);
}
