package com.hs.filter;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * �������������װ������
 * @author Administrator
 *
 */
public class CustomRequset extends HttpServletRequestWrapper {

	public CustomRequset(HttpServletRequest request) {
		super(request);
	}
	/**
	 * 
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		HashMap<String,String[]> newMap = new HashMap<String, String[]>();
		/**
		 * ��ȡԭʼMap,���е�����������ģ�
		 */
		Map<String, String[]> parameterMap = super.getParameterMap();
		/**
		 * ��ԭʼMap�е����ݽ������󣬷��뵽��newMap�С�
		 */
		try {
			for (String key : parameterMap.keySet()) {
				String[] values = parameterMap.get(key);
				for (int i=0;i<values.length;i++) {
					/**
					 * �����ַ���ǰ�ı�����д�ɢ�������롣
					 * tomcat8֮ǰ��URL�в�����Ĭ�Ͻ�����ISO-8859-1����tomcat8��Ĭ�Ͻ���Ϊutf-8��
					 */
					byte[] bytes = values[i].getBytes("UTF-8");
					/**
					 * ����ɢ����ֽ����鰴��Ҫ����н��롣
					 */
					values[i]  = new String (bytes,"UTF-8");
				}
				/**
				 * ������������ݣ����뵽��newMap�С�
				 */
				newMap.put(key, values);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/**
		 * �����µ�newMap
		 */
		return newMap;
	}
	
	@Override
	public Enumeration<String> getParameterNames() {
		Map<String, String[]> parameterMap = this.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		Vector keyVector = (Vector)keySet;
		return keyVector.elements();
	}
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = this.getParameterMap();
		return parameterMap.get(name);
	}
	@Override
	public String getParameter(String name) {
		return this.getParameterValues(name)[0];
	}
}
