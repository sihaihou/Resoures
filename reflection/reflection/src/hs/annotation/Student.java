package hs.annotation;


@SxtTable("student")
public class Student {
	@SxtField(columnName="name",type="verchar",length=10)
	private String name;	
	@SxtField(columnName="age",type="int",length=3)
	private int age;
	@SxtField(columnName="id",type="int",length=10)
	private int id;
	
	public Student() {
	}
	public Student(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
