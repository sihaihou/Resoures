package com.reyco.core.springmvc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.reyco.core.springmvc.annotation.Autowired;
import com.reyco.core.springmvc.annotation.Controller;
import com.reyco.core.springmvc.annotation.RequestMapping;
import com.reyco.core.springmvc.annotation.RequestParam;
import com.reyco.core.springmvc.annotation.Service;
import com.reyco.core.springmvc.config.PropertiesUtil;

public class DispatcherServlet extends HttpServlet {
	/**
	 *    存放所有的class类
	 *    key:   fileName.class
	 *    value: scanPackage.fileName.class
	 */
	private static final Map<String, String> classFileMap = new HashMap<String, String>();
	/**
	 *    ioc容器:存放所有的bean
	 *    key:   fileName首字母小写
	 *    value: Class实例对象
	 */
	private static final Map<String, Object> iocMap = new HashMap<String, Object>();
	/**
	 *    存放所有的请求方法
	 *    key: 请求路径  /base/base
	 *    value: 方法全名
	 */
	private static final Map<String, Method> urlMap = new HashMap<String, Method>();
	/**
	 *    存放所有的Controller对象
	 *    key:	请求路径  /base/base
	 *    value: Controller的实例对象
	 */
	private static final Map<String, Object> controllerMap = new HashMap<String, Object>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 扫描文件
		//readFile("com.reyco.springmvc");
		readFile();
		// 反射实例化类
		initIoc();
		// 自动注入
		doAutowired();
		// 请求映射
		doHandler();
	}
	/*public static String readConfig() {
		return readConfig("springmvc.xml");
	}*/
	/**
	 *  解析Xml文件
	 * @return
	 */
	/*public static String readConfig(String xmlName) {
		String  scanPackage ="";
		try {
			// 获取流
			InputStream is = DispatcherServlet.class.getClassLoader().getResourceAsStream(xmlName);
			// 获取Dom解析器
			Document document = new SAXReader().read(is);
			// 获取根节点
			Element root = document.getRootElement();
			// 获取根节点下所有字节的
			List<Element> eleContext = root.elements();
			if (null != eleContext) {
				for (Element element : eleContext) {
					scanPackage = element.attributeValue("base-package");
				}
			}
		} catch (Exception e) {
			try {
				throw new Exception("xml文件读取失败");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return scanPackage;
	}*/
	private void readFile() {
		//String readConfig = readConfig();
		String readConfig =PropertiesUtil.getValue("base.package");
		readFile(readConfig);
	}
	
	/**
	 *  扫描指定包下所有的类并添加到classFileMap集合中
	 * 		com.reyco.springmvc
	 * @param scanPackage  扫描的包
	 */
	private void readFile(String scanPackage) {
		URL url = this.getClass().getResource("/" + scanPackage.replaceAll("\\.", "/"));
		String filePath = url.getFile();
		File file = new File(filePath);
		String[] fileList = file.list();
		for (String path : fileList) {
			File f = new File(filePath + "/" + path);
			if (f.isDirectory()) {
				readFile(scanPackage + "." + f.getName());
			} else {
				classFileMap.put(f.getName(), scanPackage + "." + f.getName());
			}
		}
	}
	/**
	 *     初始化Ioc容器
	 */
	private void initIoc() {
		try {
			for (Entry<String, String> entry : classFileMap.entrySet()) {
				String value = entry.getValue();
				Class clazz = Class.forName(value.replaceAll(".class", ""));
				if (clazz.isAnnotationPresent(Controller.class)) {
					Object instance = clazz.newInstance();
					Controller controller = (Controller) clazz.getAnnotation(Controller.class);
					String key = controller.value();
					iocMap.put(key, instance);
				} else if (clazz.isAnnotationPresent(Service.class)) {
					Object instance = clazz.newInstance();
					Service Service = (Service) clazz.getAnnotation(Service.class);
					String key = Service.value();
					iocMap.put(key, instance);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *    属性注入
	 */
	private void doAutowired() {
		try {
			for (Entry<String, Object> entry : iocMap.entrySet()) {
				Object value = entry.getValue();
				Class clazz = value.getClass();
				if (clazz.isAnnotationPresent(Controller.class)) {
					Field[] fields = clazz.getDeclaredFields();
					for (Field field : fields) {
						field.setAccessible(true);
						if (field.isAnnotationPresent(Autowired.class)) {
							String name = field.getName();
							field.set(value, iocMap.get(name));
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}
	/**
	 *    
	 */
	private void doHandler() {
		if (iocMap.size() <= 0)
			return;
		for (Entry<String, Object> entry : iocMap.entrySet()) {
			Object instance = entry.getValue();
			Class<? extends Object> clazz = instance.getClass();
			if (clazz.isAnnotationPresent(Controller.class)) {
				RequestMapping clazzRequestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
				String clazzPath = clazzRequestMapping.value();
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(RequestMapping.class)) {
						RequestMapping methodRequestMapping = (RequestMapping) method
								.getAnnotation(RequestMapping.class);
						String methoPath = methodRequestMapping.value();
						String url = clazzPath + methoPath;
						urlMap.put(url, method);
						controllerMap.put(url, instance);
					} else {
						continue;
					}
				}
			} else {
				continue;
			}
		}
	}
	/**
	 * 获取请求参数
	 * @param req
	 * @param resp
	 * @param method
	 * @return
	 */
	private static Object[] hand(HttpServletRequest req, HttpServletResponse resp,Method method) {
		Class<?>[] parameters = method.getParameterTypes();
		// 存放参数
		Object[] paramValues = new Object[parameters.length];
		int args_i = 0;
		int index = 0;
		for (Class<?> parameter : parameters) {
			if(ServletRequest.class.isAssignableFrom(parameter)) {
				paramValues[args_i++] = req;
			}
			if(ServletResponse.class.isAssignableFrom(parameter)) {
				paramValues[args_i++] = resp;
			}
			Annotation[] annotations = method.getParameterAnnotations()[index];
			for (Annotation annotation : annotations) {
				if(RequestParam.class.isAssignableFrom(annotation.getClass())) {
					RequestParam requestParam= (RequestParam)annotation;
					paramValues[args_i++]=req.getParameter(requestParam.value());
				}
			}
			index++;
		}
		return paramValues;
	}
	private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.replaceAll(context, "");
		// 通过当前的path获取handlerMap的方法名
		Method method = (Method) urlMap.get(path);
		PrintWriter out = resp.getWriter();
		if (method == null) {
			out.print("404! server buy.....");
			return;
		}
		try {
			method.invoke(this.controllerMap.get(path), hand(req,resp,method));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			doDispatcher(req,resp);
		} catch (Exception e) {
			resp.getWriter().println("500,server exception...");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
