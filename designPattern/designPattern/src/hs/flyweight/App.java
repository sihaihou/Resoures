package hs.flyweight;
/**
 * ��Ԫģʽ
 * @author ���ĺ�
 */
public class App {
	public static void main(String[] args) {
		ChessFlyWeight chess1=ChessFlyWeightFactory.getChess("��ɫ");
		ChessFlyWeight chess2=ChessFlyWeightFactory.getChess("��ɫ");
		System.out.println(chess1==chess2);
		
		System.out.println("�����ⲿ״̬�Ĵ���");		
		chess1.display(new Doordinate(10,10));
		chess2.display(new Doordinate(20,20));
		System.out.println(chess1==chess2);
	}
}
