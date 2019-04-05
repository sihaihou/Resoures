package hs.service;

import java.util.List;

import hs.pojo.Detail;

public interface DetailService {
	
	public List<Detail> listByOrderId(int id);
	public int delete(int orderId,int detailId);
	
}
