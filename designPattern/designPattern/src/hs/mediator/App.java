package hs.mediator;
/**
 * �н�ģʽ
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		Mediator m=new President();
		Market k=new Market(m);
		Development d=new Development(m);
		Finacial f=new Finacial(m);		
		f.outAction();
	}
}	
