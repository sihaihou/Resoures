package hs.dao;

import java.util.List;

import hs.pojo.Order;

public interface OrderDao {
	
	public List<Order> list();
	public int update(Order order);
	public Order getById(int id);	
	
}
