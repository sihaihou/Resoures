package hs.prototype;

import java.util.Date;
/**
 * ԭ��ģʽ------>ǳ����(ǳ��¡)
 * @author Administrator
 */
public class App {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date=new Date(123123123L);
		Sheep s1=new Sheep("����",date);
		Sheep s2=(Sheep) s1.clone();
		System.out.println(s1+"\t"+s1.getName()+"---->"+s1.getBirthday());
		//������ĺ� s2 ��¡Ҳ��Ӧ����
		date.setTime(321213543123L);
		System.out.println(s1+"\t"+s1.getName()+"---->"+s1.getBirthday());
		
		//���Ը���s2������
		s2.setName("�����");
		System.out.println(s2+"\t"+s2.getName()+"---->"+s2.getBirthday());
	}
}
