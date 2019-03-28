package hs.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hs.dao.OrderDao;
import hs.pojo.Order;
@Repository("orderDao")
public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao{
	
	@Autowired //×¢Èë
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	
	@Override
	public List<Order> list() {
		return this.getSqlSession().selectList("hs.pojo.order.mapper.list");
	}
	@Override
	public int update(Order order) {
		return this.getSqlSession().update("hs.pojo.order.mapper.update",order);
	}
	@Override
	public Order getById(int id) {
		return this.getSqlSession().selectOne("hs.pojo.order.mapper.getById",id);
	}
}
