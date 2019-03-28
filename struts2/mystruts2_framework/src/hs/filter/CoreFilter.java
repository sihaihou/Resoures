package hs.filter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Filter.Chain;

import hs.core.Action;
import hs.core.ActionMapper;
import hs.core.Result;

public class CoreFilter implements Filter{

	@Override
	public void destroy() {
			
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
		try {
			//���������󣬽���.xml�����ļ�
			ActionMapper.parser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest )rq;
		HttpServletResponse resp = (HttpServletResponse)rp;
		//1.������ӳ�䵽action��
		Action targetAction = reqToAction(req);
		if(targetAction==null){
			chain.doFilter(rq, rp);
		}
//����	System.out.println(targetAction.getName()+"---"+targetAction.getClasses());
		//2.����action����
		try {
			Object proxyAction = createProxyAction(targetAction.getClasses());
			//3.���û��ύ���������õ�action��������
			setProperty(req,proxyAction);
			//4.ִ��action�ķ���
			String  result = execute(proxyAction,targetAction.getMethod());
			//5.������
			Result r = targetAction.getReslutMap().get(result);
			resultExecute(req,resp,r,proxyAction);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//1.������ӳ�䵽action��
	private Action reqToAction(HttpServletRequest req){
		String path =  req.getRequestURI();
		//ֻ������action��β������
		if(!path.endsWith(".action")){
			return null;
		}
		//��ȡ��������
		String reqName = path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."));
		return ActionMapper.actionMap.get(reqName);
	}
	//2.����action����
	private Object createProxyAction(String className) throws Exception{
		Class clazz = Class.forName(className);
		return clazz.newInstance();
	}
	//3.���û��ύ���������õ�action��������------���˺ܶ�
	private void setProperty(HttpServletRequest req,Object obj) throws Exception{
		//����Class
		Class clazz = obj.getClass();
		Map map = req.getParameterMap();
		for(Iterator iter = map.keySet().iterator();iter.hasNext();){
			Object key = iter.next();
			//�����ύ����ȥ��Filed
			Field field = clazz.getDeclaredField(key.toString());
			if(field==null){
				continue;
			}
			field.setAccessible(true);
			//Ҫ������Ӧ������ת��  -----ʡ����
			field.set(obj, req.getParameter(key.toString()));
			field.setAccessible(false);
//����		System.out.println(key+"==="+req.getParameter(key.toString()));
		}
	}
	//4.ִ��action�ķ���
	private String execute(Object proxyAction, String method) throws Exception {
		Class clazz = proxyAction.getClass();
		Method m = clazz.getDeclaredMethod(method);
		return (String)m.invoke(proxyAction);
	}
	//5.������
	private void resultExecute(HttpServletRequest req, HttpServletResponse resp, Result r, Object proxyAction) throws Exception {
		if("redirect".equals(r.getType())){
			resp.sendRedirect(r.getLocation());
			return ;
		}
		//��action������ֵ ���õ�req��attribute��
		Class clazz = proxyAction.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field fd: fields){
			fd.setAccessible(true);
			req.setAttribute(fd.getName(),fd.get(proxyAction));
			fd.setAccessible(false);
		}
		req.getRequestDispatcher(r.getLocation()).forward(req, resp);
	}
}
