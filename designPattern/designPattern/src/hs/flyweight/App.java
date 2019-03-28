package hs.flyweight;
/**
 * 享元模式
 * @author 侯四海
 */
public class App {
	public static void main(String[] args) {
		ChessFlyWeight chess1=ChessFlyWeightFactory.getChess("黑色");
		ChessFlyWeight chess2=ChessFlyWeightFactory.getChess("黑色");
		System.out.println(chess1==chess2);
		
		System.out.println("增加外部状态的处理");		
		chess1.display(new Doordinate(10,10));
		chess2.display(new Doordinate(20,20));
		System.out.println(chess1==chess2);
	}
}
