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
			//程序启动后，解析.xml配置文件
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
		//1.将请求映射到action上
		Action targetAction = reqToAction(req);
		if(targetAction==null){
			chain.doFilter(rq, rp);
		}
//测试	System.out.println(targetAction.getName()+"---"+targetAction.getClasses());
		//2.创建action对象
		try {
			Object proxyAction = createProxyAction(targetAction.getClasses());
			//3.将用户提交的数据设置到action的属性上
			setProperty(req,proxyAction);
			//4.执行action的方法
			String  result = execute(proxyAction,targetAction.getMethod());
			//5.处理结果
			Result r = targetAction.getReslutMap().get(result);
			resultExecute(req,resp,r,proxyAction);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	//1.将请求映射到action上
	private Action reqToAction(HttpServletRequest req){
		String path =  req.getRequestURI();
		//只处理以action结尾的请求
		if(!path.endsWith(".action")){
			return null;
		}
		//获取请求名称
		String reqName = path.substring(path.lastIndexOf("/")+1,path.lastIndexOf("."));
		return ActionMapper.actionMap.get(reqName);
	}
	//2.创建action对象
	private Object createProxyAction(String className) throws Exception{
		Class clazz = Class.forName(className);
		return clazz.newInstance();
	}
	//3.将用户提交的数据设置到action的属性上------简化了很多
	private void setProperty(HttpServletRequest req,Object obj) throws Exception{
		//创建Class
		Class clazz = obj.getClass();
		Map map = req.getParameterMap();
		for(Iterator iter = map.keySet().iterator();iter.hasNext();){
			Object key = iter.next();
			//根据提交参数去找Filed
			Field field = clazz.getDeclaredField(key.toString());
			if(field==null){
				continue;
			}
			field.setAccessible(true);
			//要进行相应的类型转换  -----省略了
			field.set(obj, req.getParameter(key.toString()));
			field.setAccessible(false);
//测试		System.out.println(key+"==="+req.getParameter(key.toString()));
		}
	}
	//4.执行action的方法
	private String execute(Object proxyAction, String method) throws Exception {
		Class clazz = proxyAction.getClass();
		Method m = clazz.getDeclaredMethod(method);
		return (String)m.invoke(proxyAction);
	}
	//5.处理结果
	private void resultExecute(HttpServletRequest req, HttpServletResponse resp, Result r, Object proxyAction) throws Exception {
		if("redirect".equals(r.getType())){
			resp.sendRedirect(r.getLocation());
			return ;
		}
		//将action的属性值 设置到req的attribute中
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
