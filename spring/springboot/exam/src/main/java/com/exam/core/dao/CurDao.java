package com.exam.core.dao;
/**
 * 查询、更新、新增接口
 * @author reyco
 *
 * @param <T>
 */
public interface CurDao<T> extends SelectDao<T>,UpdateDao<T>,InsertDao<T> {
	

}
