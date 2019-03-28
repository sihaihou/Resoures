package hs.flyweight;
/**
 * ������Ԫ��
 * @author Administrator
 */
public interface ChessFlyWeight {
	void  setColor(String c); //������ɫ
	String  getColor(); //�����ɫ
	void display(Doordinate c);//��ʾλ��
}


/**
 * ������Ԫ��
 * @author Administrator
 */
class ConcreteChess implements ChessFlyWeight{
	//��ɫ ����
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
		System.out.println("���ӵ���ɫ��"+color+"\t"+"��ǰ���ӵ�λ�ã�"+c.getX()+"-->"+c.getY());
	}
}
