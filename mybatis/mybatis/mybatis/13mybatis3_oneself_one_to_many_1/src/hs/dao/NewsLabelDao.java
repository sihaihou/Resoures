package hs.dao;

import java.util.List;

import hs.pojo.NewsLabel;
/**
 * ��ѯָ����Ŀ������������Ŀ
 * @author Administrator
 *
 */
public interface NewsLabelDao {
	
	public List<NewsLabel> selectNewsLabelByParent(int pid);
	
}
