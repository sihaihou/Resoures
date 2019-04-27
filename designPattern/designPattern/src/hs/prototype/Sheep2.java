package hs.prototype;

import java.util.Date;
/**
 * ԭ��ģʽ------>���(���¡)
 * @author Administrator
 */
public class Sheep2 implements Cloneable{   //1970 Ӣ���Ŀ�¡��  ����
	private String name;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();   //ֱ�ӵ���Object�����clone()����		
		//������´���ʵ�����
		Sheep2 s=(Sheep2) obj; 
		s.birthday=(Date) this.birthday.clone();		
		return obj;
	}
	
	public Sheep2() {
	}
	public Sheep2(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
