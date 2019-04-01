package com.reyco.annotation.core;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.reyco.annotation.configration.Bean;
import com.reyco.annotation.configration.Property;
import com.reyco.annotation.entity.Student;

public class AppcationXml {
	// 所有xml的bean
	private static Map<String, Bean> content;
	// 存放创建的bean对象,相当于IOC容器
	private static Map<String, Object> ioc = new HashMap<String, Object>();
	/**
	 * 
	 */
	public AppcationXml() {
		this("reyco.xml");
	}
	/**
	 * 
	 * @param xmlName
	 */
	public AppcationXml(String xmlName) {
		initBeanMap(xmlName);
	}
	/**
	 * 初始化ioc容器
	 * 
	 * @param xmlName
	 */
	public void initBeanMap(String xmlName) {
		content = BeanConfiguration.readConfig(xmlName);
		for (Map.Entry<String, Bean> beanEntry : content.entrySet()) {
			// xmlBean的id
			String id = beanEntry.getKey();
			// xmlBean
			Bean bean = beanEntry.getValue();
			// bean的class
			String beanClassValue = bean.getClasses();
			// 创建bean对象
			Object obj = createObject(bean);
			// 放入beanMap集合中
			ioc.put(id, obj);
		}
	}
	/**
	 * 根据xmlBean创建bean对象
	 * 
	 * @param bean
	 * @return
	 */
	private Object createObject(Bean bean) {
		Object beanObj = null;
		Class clazz = null;
		try {
			// 根据class全路径创建class对象
			clazz = Class.forName(bean.getClasses());
			beanObj = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Property> propertes = bean.getPropertes();
		if (null != propertes) {
			for (Property property : propertes) {
				// property的属性name
				String name = property.getName();
				// property的属性value
				String value = property.getValue();
				// property的属性ref
				String ref = property.getRef();
				// 设置属性值
				if (null != value && !value.equals("")) {
					try {
						Map<String, String[]> parmMap = new HashMap<String, String[]>();
						parmMap.put(name, new String[] { value });
						BeanUtils.populate(beanObj, parmMap);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (null != ref && !ref.equals("")) {
					try {
						Object existBean = ioc.get(ref);
						if (existBean == null) {
							// 递归的创建一个bean
							existBean = createObject(content.get(ref));
							// beanMap.put(ref, existBean);
						}
						BeanUtils.setProperty(beanObj, name, existBean);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return beanObj;
	}
	/**
	 * 获取bean对象,根据id获取bean对象
	 * 
	 * @param name
	 * @return
	 */
	public Object getbean(String name) {
		return ioc.get(name);
	}
	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		AppcationXml mapperFilter = new AppcationXml();
		Object o = mapperFilter.getbean("student");
		if(o instanceof Student) {
			Student s = (Student)o;
			System.out.println(s.getName());
		}
		
	}
}
