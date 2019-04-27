package hs.prototype;

import java.util.Date;
/**
 * 原型模式------>深复制(深克隆)
 * @author Administrator
 */
public class App2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date=new Date(123123123L);
		Sheep2 s=new Sheep2("多利",date);
		Sheep2 s2=(Sheep2) s.clone();
		System.out.println(s.getName()+"---->"+s.getBirthday());
		//这里更改后 s2克隆不会更改
		date.setTime(321213543123L);
		System.out.println(s.getName()+"---->"+s.getBirthday());
		
		//可以更改s2的属性
		s2.setName("多多利");
		System.out.println(s2.getName()+"---->"+s2.getBirthday());
	}
}
