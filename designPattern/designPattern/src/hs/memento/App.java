package hs.memento;
/**
 * ����¼ģʽ
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		CareTaker t=new CareTaker();
		Emp e=new Emp("���",18,4000);
		System.out.println("û����:"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary());
		t.setMemento(e.memento());//����
		e.setName("����");
		e.setAge(28);
		e.setSalary(8000);
		System.out.println("�Ѹ���:"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary());
		e.recovery(t.getMemento());//�ָ�������¼����Ķ���
		System.out.println("�ָ���:"+e.getName()+"\t"+e.getAge()+"\t"+e.getSalary());

	}
}
