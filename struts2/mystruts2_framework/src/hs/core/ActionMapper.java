package hs.core;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class ActionMapper {
	public static Map<String, Action> actionMap = new HashMap<String, Action>();
	public static void parser() throws Exception{
		InputStream is = ActionMapper.class.getClassLoader().getResourceAsStream("framework.xml");
		//获取Dom解析器
		Document document = new SAXReader().read(is);
		//获取根节点
		Element root = document.getRootElement();
		//处理action节点
		List<Element> actions = root.elements();
		for(Element element:actions){
			Action action = new Action();
			//获取action属性值
			action.setName(element.attributeValue("name"));
			action.setClasses(element.attributeValue("classes"));
//测试：  		System.out.println(element.attributeValue("name"));
			String method = element.attributeValue("method");
			if( method!= null){
				action.setMethod(method);
				List<Element> results = element.elements();
				for(Element e:results){
					Result result = new Result();
					//获取result属性值					
					String resultName = e.attributeValue("name");
					String resultType = e.attributeValue("type");					
					if(resultName!=null){
						result.setName(resultName);
					}
					if(resultType!=null){
						result.setType(resultType);
					}
					result.setLocation(e.getStringValue());
//测试					System.out.println(e.getStringValue());
					//将result对象添加到action中
					action.getReslutMap().put(result.getName(), result);
				}
				//将Action对象放入到ActionMap中
				actionMap.put(action.getName(), action);
//测试			System.out.println(action.getName()+"classes："+ action.getClasses()+"method："+action.getMethod());
			}			
		}
		
	}	
}
