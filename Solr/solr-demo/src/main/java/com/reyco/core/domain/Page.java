package com.reyco.core.domain;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("all")
public class Page<T> implements Serializable{
	/**
	 * 第几页
	 */
	private Integer pageNo;
	/**
	 * 每页显示多少条记录
	 */
	private Integer pageSize;
	/**
	 * 有多少条数据
	 */
	private Long totalCount;

	/**
	 * 一共有多少页
	 */
	private Integer totalPage;
	/**
	 *   每页存放的记录
	 */
	private List<T> list;
	
	public Page() {
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", list=" + list + "]";
	}
}
