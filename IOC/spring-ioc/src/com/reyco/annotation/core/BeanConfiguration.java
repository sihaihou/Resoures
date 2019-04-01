package com.reyco.annotation.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.reyco.annotation.configration.Bean;
import com.reyco.annotation.configration.Property;
import com.reyco.annotation.exception.XMLBeanExcetion;
import com.reyco.annotation.exception.XMLPropertyException;
import com.reyco.annotation.exception.XMLException;

/**
 * xml配置文件解析
 * 
 * @author reyco
 *
 */
public class BeanConfiguration {
	/**
	 *  解析Xml文件
	 * @return
	 */
	public static Map<String,Bean> readConfig(String xmlName) {
		Map<String, Bean> beansMap = new HashMap<>();;
		try {
			// 获取流
			InputStream is = BeanConfiguration.class.getClassLoader().getResourceAsStream(xmlName);
			// 获取Dom解析器
			Document document = new SAXReader().read(is);
			// 获取根节点
			Element root = document.getRootElement();
			// 获取所有bean节点
			List<Element> eleBeans = root.elements();
			if (null != eleBeans) {
				for (Element element : eleBeans) {
					Bean bean = new Bean();
					String id = element.attributeValue("id");
					// 设置bean的id属性值
					if (null != id && !id.equals("")) {
						bean.setId(id);
					}
					// 设置bean的class属性值
					if (null == element.attributeValue("class")) {
						throw new XMLBeanExcetion("bean的class不能为null");
					} else {
						bean.setClasses(element.attributeValue("class"));
					}
					// 获取所有property节点
					List<Element> elePropertes = element.elements();
					// 循环处理property节点
					for (Element e : elePropertes) {
						Property property = new Property();
						// 设置property的name属性
						if (null == e.attributeValue("name")) {
							throw new XMLPropertyException("name 不能为null");
						} else {
							property.setName(e.attributeValue("name"));
						}
						// property的value和ref不能同时为null
						if (null == e.attributeValue("value") && null == e.attributeValue("ref")) {
							throw new XMLPropertyException("value and ref 不能同时为null");
						}
						// property的value和ref不能同时有值
						if (null != e.attributeValue("value") && null != e.attributeValue("ref")) {
							throw new XMLPropertyException("value and ref 不能同时不为null");
						}
						// 设置property的value属性
						if (null != e.attributeValue("value")) {
							property.setValue(e.attributeValue("value"));
						}
						// 设置property的ref属性
						if (null != e.attributeValue("ref")) {
							property.setRef(e.attributeValue("ref"));
						}
						// 设置bean的property集合
						bean.getPropertes().add(property);
					}
					// 讲bean转让map
					beansMap.put(id, bean);
				}
			}
		} catch (Exception e) {
			try {
				throw new XMLException("xml文件读取失败");
			} catch (XMLException e1) {
				e1.printStackTrace();
			}
		}
		return beansMap;
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Bean> m = BeanConfiguration.readConfig("reyco.xml");
		System.out.println(m);
	}
	
}
