package com.reyco.annotation.configration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author reyco
 *
 */
/**
 * 对应xml文件的bean标签
 * @author reyco
 *
 */
public class Bean {
	/**
	 * 对应bean的id
	 */
	private String id;
	/**
	 * 对应bean的class
	 */
	private String classes;
	/**
	 * 对应bean的pri
	 */
	private List<Property>  propertes= new ArrayList<>();
	
	public Bean() {
	}
	public Bean(String id) {
		super();
		this.id = id;
	}
	public Bean(String id, String classes) {
		super();
		this.id = id;
		this.classes = classes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public List<Property> getPropertes() {
		return propertes;
	}
	public void setPropertes(List<Property> propertes) {
		this.propertes = propertes;
	}
	@Override
	public String toString() {
		return "Bean [id=" + id + ", classes=" + classes + ", propertes=" + propertes + "]";
	}
}
