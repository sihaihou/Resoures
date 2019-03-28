package hs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import hs.pojo.User;

public interface UserMapper {
	@Select("select * from user")
	public List<User> selectUser(); 
}
