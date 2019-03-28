package hs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import hs.dao.UserDao;
import hs.pojo.User;
/**
 * spring整合mybatis：
 * 			第二种方式继承SqlSessionDaoSupport类
 * 
 * 不需要管理SqlSessionTempLate
 * 直接getSqlSession()方法
 * @author Administrator
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Override
	public List<User> selectUser() {
		return this.getSqlSession().selectList("hs.pojo.user.mapper.selectAll");
	}
}
