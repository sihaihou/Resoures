package hs.javassist1;

@Author(name="ºîËÄº£",year=2017)
public class Emp {	
	private String name;
	private int age;
	public Emp() {
	}
	public Emp(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void say(int a){
		System.out.println("say:"+a);
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
