package hs.memento;
/**
 * Դ��������
 * @author Administrator
 *
 */
public class Emp {
	private String name;
	private int age;
	private double salary;
	//���б��������������ر�������
	public EmpMemento memento(){
		return new EmpMemento(this);	
	}
	//�������ݻָ����ָ���ָ������¼�����ֵ
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
