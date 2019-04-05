package hs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import hs.dao.UserDao;
import hs.pojo.User;
/**
 * spring整合mybatis：
 * 				第一种方法：注入SqlSessionTemplate
 * 	未加声明式事务
 * @author Administrator
 */
public class UserDaoImpl implements UserDao{
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<User> selectUser() {
		User user = new User();
		user.setName("王五");
		user.setPwd("555555");
		sqlSession.insert("hs.pojo.User.mapper.add",user);
		sqlSession.delete("hs.pojo.User.mapper.remove",8);
		return sqlSession.selectList("hs.pojo.User.mapper.selectAll");
	}

}
