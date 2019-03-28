package hs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import hs.dao.UserDao;
import hs.pojo.User;
/**
 * spring����mybatis��
 * 			�ڶ��ַ�ʽ�̳�SqlSessionDaoSupport��
 * 
 * ����Ҫ����SqlSessionTempLate
 * ֱ��getSqlSession()����
 * @author Administrator
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	
	@Override
	public List<User> selectUser() {
		return this.getSqlSession().selectList("hs.pojo.user.mapper.selectAll");
	}
}
