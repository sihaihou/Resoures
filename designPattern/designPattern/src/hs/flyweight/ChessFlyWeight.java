package hs.flyweight;
/**
 * 抽象享元类
 * @author Administrator
 */
public interface ChessFlyWeight {
	void  setColor(String c); //设置颜色
	String  getColor(); //获得颜色
	void display(Doordinate c);//显示位置
}


/**
 * 具体享元类
 * @author Administrator
 */
class ConcreteChess implements ChessFlyWeight{
	//颜色 共享
	private String color;
	
	public ConcreteChess(String color) {
		this.color = color;
	}
	@Override
	public void setColor(String color) {
		this.color=color;
	}
	@Override
	public String getColor() {
		return color;
	}
	@Override
	public void display(Doordinate c) {
		System.out.println("棋子的颜色："+color+"\t"+"当前棋子的位置："+c.getX()+"-->"+c.getY());
	}
}
