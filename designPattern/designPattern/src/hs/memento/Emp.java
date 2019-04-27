package hs.memento;
/**
 * 源发器对象
 * @author Administrator
 *
 */
public class Emp {
	private String name;
	private int age;
	private double salary;
	//进行备忘操作，并返回备忘对象
	public EmpMemento memento(){
		return new EmpMemento(this);	
	}
	//进行数据恢复，恢复成指定备忘录对象的值
	public void recovery(EmpMemento memneto){
		this.name=memneto.getName();
		this.age=memneto.getAge();
		this.salary=memneto.getSalary();
	}
	
	public Emp(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getSalary() {
		return salary;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
