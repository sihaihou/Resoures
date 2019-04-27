package hs.dao;

import hs.pojo.NewsLabel;
/**
 * 查询指定栏目及其所有子孙栏目
 * @author Administrator
 *
 */
public interface NewsLabelDao {
	
	public NewsLabel selectNewsLabelById(int id);
	
}
