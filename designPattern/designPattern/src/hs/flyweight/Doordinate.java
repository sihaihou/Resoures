package hs.flyweight;
/**
 * �ⲿ״̬(����λ����)UnSharedConcreteFlyWeight
 * @author Administrator
 *
 */
public class Doordinate {
	private int x,y;
	public Doordinate() {
	}
	public Doordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
