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
	// ����xml��bean
	private static Map<String, Bean> content;
	// ��Ŵ�����bean����,�൱��IOC����
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
	 * ��ʼ��ioc����
	 * 
	 * @param xmlName
	 */
	public void initBeanMap(String xmlName) {
		content = BeanConfiguration.readConfig(xmlName);
		for (Map.Entry<String, Bean> beanEntry : content.entrySet()) {
			// xmlBean��id
			String id = beanEntry.getKey();
			// xmlBean
			Bean bean = beanEntry.getValue();
			// bean��class
			String beanClassValue = bean.getClasses();
			// ����bean����
			Object obj = createObject(bean);
			// ����beanMap������
			ioc.put(id, obj);
		}
	}
	/**
	 * ����xmlBean����bean����
	 * 
	 * @param bean
	 * @return
	 */
	private Object createObject(Bean bean) {
		Object beanObj = null;
		Class clazz = null;
		try {
			// ����classȫ·������class����
			clazz = Class.forName(bean.getClasses());
			beanObj = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Property> propertes = bean.getPropertes();
		if (null != propertes) {
			for (Property property : propertes) {
				// property������name
				String name = property.getName();
				// property������value
				String value = property.getValue();
				// property������ref
				String ref = property.getRef();
				// ��������ֵ
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
							// �ݹ�Ĵ���һ��bean
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
	 * ��ȡbean����,����id��ȡbean����
	 * 
	 * @param name
	 * @return
	 */
	public Object getbean(String name) {
		return ioc.get(name);
	}
	/**
	 * ����
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
