package hs.converter;

import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

import hs.entity.Point;
public class PointConverter extends StrutsTypeConverter{
	/**
	 * 	将表单提交到字符串数据，转换为指定的自定义类型
	 * 		arg0 是ActionContext
	 * 		arg1  要进行类型转换的字符串数组
	 * 		arg2  被转换的类型
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
	 * 将自定义类型 转换为字符串在前台页面显示------通过ognl表达式将会使用该方法进行转换
	 * 	arg0  ---ActionContext
	 * 	arg1 要转换的对象
	 */
	@Override
	public String convertToString(Map context, Object o) {	
		Point point = (Point)o;
		return "("+point.getX()+","+point.getY()+")";
	}
}
