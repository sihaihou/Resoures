package hs.converter;

import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

import hs.entity.Point;
public class PointConverter extends StrutsTypeConverter{
	/**
	 * 	�����ύ���ַ������ݣ�ת��Ϊָ�����Զ�������
	 * 		arg0 ��ActionContext
	 * 		arg1  Ҫ��������ת�����ַ�������
	 * 		arg2  ��ת��������
	 */	
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String arg =values[0];
		Point point = new Point();
		String x=arg.substring(1,arg.indexOf(","));
		String y=arg.substring(arg.indexOf(",")+1,arg.length()-1);
		point.setX(Integer.parseInt(x));
		point.setY(Integer.parseInt(y));		
		return point;
	}	
	/**
	 * 
	 * ���Զ������� ת��Ϊ�ַ�����ǰ̨ҳ����ʾ------ͨ��ognl���ʽ����ʹ�ø÷�������ת��
	 * 	arg0  ---ActionContext
	 * 	arg1 Ҫת���Ķ���
	 */
	@Override
	public String convertToString(Map context, Object o) {	
		Point point = (Point)o;
		return "("+point.getX()+","+point.getY()+")";
	}
}
