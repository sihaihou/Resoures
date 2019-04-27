package hs.memento;
/**
 * 备忘录模式
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		CareTaker t=new CareTaker();
		Emp e=new Emp("高淇",18,4000);
		System.out.println("没更改:"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary());
		t.setMemento(e.memento());//备忘
		e.setName("张三");
		e.setAge(28);
		e.setSalary(8000);
		System.out.println("已更改:"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary());
		e.recovery(t.getMemento());//恢复到备忘录保存的对象
		System.out.println("恢复后:"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary());

	}
}
