package com.reyco.core.util;

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
}
