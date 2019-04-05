package hs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import hs.dao.UserDao;
import hs.pojo.User;
/**
 * spring����mybatis��
 * 			�����ַ�ʽ������Ҫmybatis.cfg.xml�����ļ�
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
