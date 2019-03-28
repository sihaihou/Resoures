package hs.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
/**
 * 	原型模式(深复制)   使用序列化和反序列化实现深复制
 * @author Administrator
 */
public class App3 {
	public static void main(String[] args) throws  Exception {
		Date date=new Date(123123123L);
		Sheep s=new Sheep("多利",date);
		System.out.println(s.getName()+"---->"+s.getBirthday());
		
		//使用序列化和反序列化实现深复制
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(s);
		byte[] bytes =bos.toByteArray();	
		ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
		ObjectInputStream ois=new ObjectInputStream(bis);
		Sheep s2=(Sheep) ois.readObject();
		//这里更改后 s2克隆不会更改
		date.setTime(321213543123L);
		System.out.println(s.getName()+"---->"+s.getBirthday());
		
		//可以更改s2的属性
		s2.setName("多多利");
		System.out.println(s2.getName()+"---->"+s2.getBirthday());
	}
}
