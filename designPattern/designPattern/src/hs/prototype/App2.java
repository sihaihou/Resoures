package hs.prototype;

import java.util.Date;
/**
 * ԭ��ģʽ------>���(���¡)
 * @author Administrator
 */
public class App2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date=new Date(123123123L);
		Sheep2 s=new Sheep2("����",date);
		Sheep2 s2=(Sheep2) s.clone();
		System.out.println(s.getName()+"---->"+s.getBirthday());
		//������ĺ� s2��¡�������
		date.setTime(321213543123L);
		System.out.println(s.getName()+"---->"+s.getBirthday());
		
		//���Ը���s2������
		s2.setName("�����");
		System.out.println(s2.getName()+"---->"+s2.getBirthday());
	}
}
