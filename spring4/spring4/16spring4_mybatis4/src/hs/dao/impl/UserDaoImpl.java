package hs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import hs.dao.UserDao;
import hs.pojo.User;
/**
 * spring整合mybatis：
 * 			第四种方式：不需要mybatis.cfg.xml配置文件
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public List<User> selectUser() {
	
		return sqlSession.selectList("hs.pojo.user.mapper.selectAll");
	}

}
