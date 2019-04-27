package hs.otherObject08;

public class Test implements java.io.Serializable{		
		public /*transient */String name;  //transient不需要序列化
		public int salary;
		public Test() {
			
		}
		public Test(String name, int salary) {
			super();
			this.name = name;
			this.salary = salary;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		
}
