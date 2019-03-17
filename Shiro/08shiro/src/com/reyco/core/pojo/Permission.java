package com.reyco.core.pojo;

import java.io.Serializable;

public class Permission implements Serializable{
	private Integer id;
	private String percode;
	private String name;
	public Permission() {
	}
	public Permission(Integer id, String percode, String name) {
		super();
		this.id = id;
		this.percode = percode;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPercode() {
		return percode;
	}
	public void setPercode(String percode) {
		this.percode = percode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", percode=" + percode + ", name=" + name + "]";
	}
}
