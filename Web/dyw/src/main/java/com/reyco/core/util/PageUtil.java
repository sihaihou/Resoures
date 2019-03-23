package com.reyco.core.util;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.reyco.core.pojo.Page;

@SuppressWarnings("all")
public class PageUtil {
	public static final Integer PAGESIZE=12;
	public static final Integer PAGE_SIZE1=15;
	public static Page getPage(PageInfo pageInfo) {
		Page page = new Page();
		page.setList(pageInfo.getList());
		page.setPageNo(pageInfo.getPageNum());
		page.setPageSize(pageInfo.getPageSize());
		page.setTotalCount(pageInfo.getTotal());
		page.setTotalPage(pageInfo.getPages());
		return page;
	}
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param totalCount
	 * @param list
	 * @return
	 */
	public static Page getPage(Integer pageNo,Integer pageSize,int totalCount,List list) {
		Page page = new Page();
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalCount((long)totalCount);
		page.setTotalPage(totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1);
		return page;
	}
}
