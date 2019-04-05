package hs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hs.dao.DetailDao;
import hs.dao.OrderDao;
import hs.pojo.Detail;
import hs.pojo.Order;
import hs.service.DetailService;

@Service("detailService")
public class DetailServiceImpl implements DetailService{	
	@Autowired
	private DetailDao detailDao;
	@Autowired
	private OrderDao orderDao;	

	@Override
	public List<Detail> listByOrderId(int id) {
		return detailDao.listByOrderId(id);
	}
	@Override
	public int delete(int orderId, int detailId) {
		if(detailDao.delete(detailId)>0){
			Order order = orderDao.getById(orderId);
			List<Detail> detail = detailDao.listByOrderId(orderId);
			double totalPrice = calcuPrice(detail);
			order.setTotalPrice(totalPrice);
			if(orderDao.update(order)>0){
				return 1;
			}
		}
		return	0 ;
	}
	private double calcuPrice(List<Detail> list){
		double sum = 0;
		for(Detail detail:list){
			sum+=detail.getMenu().getPrice()*detail.getNum();
		}
		return sum;		
	}
}
