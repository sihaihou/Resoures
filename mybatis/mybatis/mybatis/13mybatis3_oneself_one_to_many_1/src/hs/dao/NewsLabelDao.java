package hs.dao;

import java.util.List;

import hs.pojo.NewsLabel;
/**
 * 查询指定栏目的所有子孙栏目
 * @author Administrator
 *
 */
public interface NewsLabelDao {
	
	public List<NewsLabel> selectNewsLabelByParent(int pid);
	
}
