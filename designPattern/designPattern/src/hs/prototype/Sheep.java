package hs.prototype;

import java.io.Serializable;
import java.util.Date;

import javax.swing.plaf.synth.SynthConstants;
/**
 * 克隆羊  多利 对象
 * @author Administrator
 */
public class Sheep implements Cloneable,Serializable{   //1970 英国的克隆羊  多利
	private String name;
	private Date birthday;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//直接调用Object对象的clone()方法
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
