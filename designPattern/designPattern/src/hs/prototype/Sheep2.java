package hs.prototype;

import java.util.Date;
/**
 * 原型模式------>深复制(深克隆)
 * @author Administrator
 */
public class Sheep2 implements Cloneable{   //1970 英国的克隆羊  多利
	private String name;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();   //直接调用Object对象的clone()方法		
		//添加以下代码实现深复制
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
