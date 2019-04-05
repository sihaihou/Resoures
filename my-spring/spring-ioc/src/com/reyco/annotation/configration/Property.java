package com.reyco.annotation.configration;
/**
 * ��Ӧxml�ļ���property��ǩ
 * @author reyco
 *
 */
public class Property {
	/**
	 * ��ǩ��������
	 */
	private String name;
	/**
	 * ��ǩ����ֵ
	 */
	private String value="";
	/**
	 * ��ǩ��������
	 */
	private String ref="";
	public Property() {
	}
	public Property(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public Property(String name, String value, String ref) {
		super();
		this.name = name;
		this.value = value;
		this.ref = ref;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	@Override
	public String toString() {
		return "Property [name=" + name + ", value=" + value + ", ref=" + ref + "]";
	}
}
