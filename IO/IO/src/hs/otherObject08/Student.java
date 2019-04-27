package hs.otherObject08;
/**
 * java.io.Serializable必须实现这个接口才能序列化
 * @author 侯四海
 */
public class Student implements java.io.Serializable{
	public String name;
	public String Id;
	//transient 不需要序列化
	public transient double match;
	public double chinese;
	public double english;

	public Student() {
	}
	public Student(String name, String id, double match, double chinese, double english) {
		super();
		this.name = name;
		Id = id;
		this.match = match;
		this.chinese = chinese;
		this.english = english;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public double getMatch() {
		return match;
	}
	public void setMatch(double match) {
		this.match = match;
	}
	public double getChinese() {
		return chinese;
	}
	public void setChinese(double chinese) {
		this.chinese = chinese;
	}
	public double getEnglish() {
		return english;
	}
	public void setEnglish(double english) {
		this.english = english;
	}	
}
