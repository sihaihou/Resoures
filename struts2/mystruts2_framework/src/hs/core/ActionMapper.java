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
		//��ȡDom������
		Document document = new SAXReader().read(is);
		//��ȡ���ڵ�
		Element root = document.getRootElement();
		//����action�ڵ�
		List<Element> actions = root.elements();
		for(Element element:actions){
			Action action = new Action();
			//��ȡaction����ֵ
			action.setName(element.attributeValue("name"));
			action.setClasses(element.attributeValue("classes"));
//���ԣ�  		System.out.println(element.attributeValue("name"));
			String method = element.attributeValue("method");
			if( method!= null){
				action.setMethod(method);
				List<Element> results = element.elements();
				for(Element e:results){
					Result result = new Result();
					//��ȡresult����ֵ					
					String resultName = e.attributeValue("name");
					String resultType = e.attributeValue("type");					
					if(resultName!=null){
						result.setName(resultName);
					}
					if(resultType!=null){
						result.setType(resultType);
					}
					result.setLocation(e.getStringValue());
//����					System.out.println(e.getStringValue());
					//��result������ӵ�action��
					action.getReslutMap().put(result.getName(), result);
				}
				//��Action������뵽ActionMap��
				actionMap.put(action.getName(), action);
//����			System.out.println(action.getName()+"classes��"+ action.getClasses()+"method��"+action.getMethod());
			}			
		}
		
	}	
}
