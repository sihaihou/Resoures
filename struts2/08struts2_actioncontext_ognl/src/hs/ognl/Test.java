package hs.ognl;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;
/**
 * ԭ�����ݷ�Ϊ����---���õĺͲ����õ�----���õ�һ����С���ݣ������õ�һ��������
 * ���ʽ�����õ�����ֱ��ȡ�������̵ļ� # ��ȡ
 * @author ���ĺ�
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
