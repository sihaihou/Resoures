package hs.dao;

import java.util.List;

import hs.pojo.User;
/**
 * ¶¯Ì¬sql²éÑ¯
 * @author Administrator
 *
 */
public interface UserDao {
	
	List<User> selectUserByIf(User user);
	
	List<User> selectUserByWhere(User user);
	
	List<User> selectUserByChoose(User user);
	
	List<User> selectUserByForeach(int[] id);
	
	List<User> selectUserByForeach2(List<Integer> id);
	
	List<User> selectUserByForeach3(List<User> user);
	
	List<User> selectUserBySqlFragment(List<User> user);
}
