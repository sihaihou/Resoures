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
 * xml�����ļ�����
 * 
 * @author reyco
 *
 */
public class BeanConfiguration {
	/**
	 *  ����Xml�ļ�
	 * @return
	 */
	public static Map<String,Bean> readConfig(String xmlName) {
		Map<String, Bean> beansMap = new HashMap<>();;
		try {
			// ��ȡ��
			InputStream is = BeanConfiguration.class.getClassLoader().getResourceAsStream(xmlName);
			// ��ȡDom������
			Document document = new SAXReader().read(is);
			// ��ȡ���ڵ�
			Element root = document.getRootElement();
			// ��ȡ����bean�ڵ�
			List<Element> eleBeans = root.elements();
			if (null != eleBeans) {
				for (Element element : eleBeans) {
					Bean bean = new Bean();
					String id = element.attributeValue("id");
					// ����bean��id����ֵ
					if (null != id && !id.equals("")) {
						bean.setId(id);
					}
					// ����bean��class����ֵ
					if (null == element.attributeValue("class")) {
						throw new XMLBeanExcetion("bean��class����Ϊnull");
					} else {
						bean.setClasses(element.attributeValue("class"));
					}
					// ��ȡ����property�ڵ�
					List<Element> elePropertes = element.elements();
					// ѭ������property�ڵ�
					for (Element e : elePropertes) {
						Property property = new Property();
						// ����property��name����
						if (null == e.attributeValue("name")) {
							throw new XMLPropertyException("name ����Ϊnull");
						} else {
							property.setName(e.attributeValue("name"));
						}
						// property��value��ref����ͬʱΪnull
						if (null == e.attributeValue("value") && null == e.attributeValue("ref")) {
							throw new XMLPropertyException("value and ref ����ͬʱΪnull");
						}
						// property��value��ref����ͬʱ��ֵ
						if (null != e.attributeValue("value") && null != e.attributeValue("ref")) {
							throw new XMLPropertyException("value and ref ����ͬʱ��Ϊnull");
						}
						// ����property��value����
						if (null != e.attributeValue("value")) {
							property.setValue(e.attributeValue("value"));
						}
						// ����property��ref����
						if (null != e.attributeValue("ref")) {
							property.setRef(e.attributeValue("ref"));
						}
						// ����bean��property����
						bean.getPropertes().add(property);
					}
					// ��beanת��map
					beansMap.put(id, bean);
				}
			}
		} catch (Exception e) {
			try {
				throw new XMLException("xml�ļ���ȡʧ��");
			} catch (XMLException e1) {
				e1.printStackTrace();
			}
		}
		return beansMap;
	}
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,Bean> m = BeanConfiguration.readConfig("reyco.xml");
		System.out.println(m);
	}
	
}
