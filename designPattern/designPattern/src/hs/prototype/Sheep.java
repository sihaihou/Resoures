package hs.prototype;

import java.io.Serializable;
import java.util.Date;

import javax.swing.plaf.synth.SynthConstants;
/**
 * ��¡��  ���� ����
 * @author Administrator
 */
public class Sheep implements Cloneable,Serializable{   //1970 Ӣ���Ŀ�¡��  ����
	private String name;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//ֱ�ӵ���Object�����clone()����
		Object obj=super.clone();   
		return obj;
	}
	public Sheep() {
	}
	public Sheep(String name, Date birthday) {
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
