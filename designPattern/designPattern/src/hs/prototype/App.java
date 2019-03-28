package hs.prototype;

import java.util.Date;
/**
 * 原型模式------>浅复制(浅克隆)
 * @author Administrator
 */
public class App {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date=new Date(123123123L);
		Sheep s1=new Sheep("多利",date);
		Sheep s2=(Sheep) s1.clone();
		System.out.println(s1+"\t"+s1.getName()+"---->"+s1.getBirthday());
		//这里更改后 s2 克隆也相应更改
		date.setTime(321213543123L);
		System.out.println(s1+"\t"+s1.getName()+"---->"+s1.getBirthday());
		
		//可以更改s2的属性
		s2.setName("多多利");
		System.out.println(s2+"\t"+s2.getName()+"---->"+s2.getBirthday());
	}
}
