package hs.bridge;

public class Brand {
	Computer brand;
	public Brand(Computer brand) {
		this.brand = brand;
	}
	public void sale(){
		brand.sale();
	}	
}

/**
 * ��˶����
 * @author Administrator
 *
 */
class ASUS extends Brand{
	public ASUS(Computer brand) {
		super(brand);
		System.out.println("���ۻ�˶����");
	}
}
/**
 * ��������
 * @author Administrator
 *
 */
class Dell extends Brand{
	public Dell(Computer brand) {
		super(brand);
		System.out.println("���۴�������");
	}
}
/**
 * �������
 * @author Administrator
 *
 */
class Lenovo extends Brand{
	public Lenovo(Computer brand) {
		super(brand);
		System.out.println("�����������");
	}
}

/**
 * ����������ӣ�����Ӱ��������
 */
/*class Shenzhou extends Brand{
	public Shenzhou(Computer brand) {
		super(brand);
		System.out.println("�������ݵ���");
	}
}*/