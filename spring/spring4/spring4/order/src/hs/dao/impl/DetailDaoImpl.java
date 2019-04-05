package hs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hs.dao.DetailDao;
import hs.pojo.Detail;
@Repository("detailDao")
public class DetailDaoImpl extends SqlSessionDaoSupport implements DetailDao{
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	@Override
	public List<Detail> listByOrderId(int id) {
		return this.getSqlSession().selectList("hs.pojo.detail.mapper.listByOrderId",id);
	}
	@Override
	public int delete(int id) {
		return this.getSqlSession().delete("hs.pojo.detail.mapper.delete",id);
	}
}
