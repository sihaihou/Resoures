package hs.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
/**
 * 	ԭ��ģʽ(���)   ʹ�����л��ͷ����л�ʵ�����
 * @author Administrator
 */
public class App3 {
	public static void main(String[] args) throws  Exception {
		Date date=new Date(123123123L);
		Sheep s=new Sheep("����",date);
		System.out.println(s.getName()+"---->"+s.getBirthday());
		
		//ʹ�����л��ͷ����л�ʵ�����
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(s);
		byte[] bytes =bos.toByteArray();	
		ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
		ObjectInputStream ois=new ObjectInputStream(bis);
		Sheep s2=(Sheep) ois.readObject();
		//������ĺ� s2��¡�������
		date.setTime(321213543123L);
		System.out.println(s.getName()+"---->"+s.getBirthday());
		
		//���Ը���s2������
		s2.setName("�����");
		System.out.println(s2.getName()+"---->"+s2.getBirthday());
	}
}
