package hs.bridge;

public interface Computer {
	void sale();
}


class Laptop implements Computer{
	@Override
	public void sale() {
		System.out.println("笔记本电脑");
	}	
}

class Desktop implements Computer{
	@Override
	public void sale() {
		System.out.println("台式电脑");
	}	
}

/**
 * 可以随意添加，不会影响其他类
 * @author Administrator
 */
/*class Aad implements Computer{
	@Override
	public void sale() {
		System.out.println("平板电脑");
	}	
}*/