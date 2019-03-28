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
 * 定义具体的请求的装饰者类
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
		 * 获取原始Map,其中的数据是乱码的，
		 */
		Map<String, String[]> parameterMap = super.getParameterMap();
		/**
		 * 将原始Map中的数据解决乱码后，放入到新newMap中。
		 */
		try {
			for (String key : parameterMap.keySet()) {
				String[] values = parameterMap.get(key);
				for (int i=0;i<values.length;i++) {
					/**
					 * 按照字符当前的编码进行打散，即编码。
					 * tomcat8之前，URL中参数的默认解码是ISO-8859-1，而tomcat8的默认解码为utf-8。
					 */
					byte[] bytes = values[i].getBytes("UTF-8");
					/**
					 * 将打散后的字节数组按照要求进行解码。
					 */
					values[i]  = new String (bytes,"UTF-8");
				}
				/**
				 * 解决乱码后的数据，放入到新newMap中。
				 */
				newMap.put(key, values);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/**
		 * 返回新的newMap
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
