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
 * 华硕电脑
 * @author Administrator
 *
 */
class ASUS extends Brand{
	public ASUS(Computer brand) {
		super(brand);
		System.out.println("销售华硕电脑");
	}
}
/**
 * 戴尔电脑
 * @author Administrator
 *
 */
class Dell extends Brand{
	public Dell(Computer brand) {
		super(brand);
		System.out.println("销售戴尔电脑");
	}
}
/**
 * 联想电脑
 * @author Administrator
 *
 */
class Lenovo extends Brand{
	public Lenovo(Computer brand) {
		super(brand);
		System.out.println("销售联想电脑");
	}
}

/**
 * 可以随意添加，不会影响其他类
 */
/*class Shenzhou extends Brand{
	public Shenzhou(Computer brand) {
		super(brand);
		System.out.println("销售神州电脑");
	}
}*/