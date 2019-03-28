package hs.memento;
/**
 * ±¸ÍüÂ¼¶ÔÏó
 * @author Administrator
 *
 */
public class EmpMemento {
	private String name;
	private int age;
	private double salary;

	public EmpMemento(Emp e) {
		this.name = e.getName();
		this.age = e.getAge();
		this.salary =e.getSalary();
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
