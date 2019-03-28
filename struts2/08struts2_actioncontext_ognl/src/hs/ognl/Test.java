package hs.ognl;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
/**
 * 原则：数据分为两类---常用的和不常用的----常用的一般是小数据，不常用的一般是数据
 * 表达式：常用的数据直接取，不抽烟的加 # 号取
 * @author 侯四海
 */
public class Test {
	public static void main(String[] args) throws OgnlException {
		Map<String ,Object> map= new HashMap<String, Object>();
		map.put("name", "zhangsan");
		User user=new User();
		user.setName("lisi");
		Object obj1 = Ognl.getValue("name", map,user);
		System.out.println(obj1);
		Object obj2 = Ognl.getValue("#name", map,user);
		System.out.println(obj2);
	}
}
