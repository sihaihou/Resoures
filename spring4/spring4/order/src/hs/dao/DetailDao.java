package hs.dao;

import java.util.List;

import hs.pojo.Detail;

public interface DetailDao {
	
	public List<Detail> listByOrderId(int id);
	public int delete(int id);
	
}
