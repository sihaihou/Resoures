package hs.bridge;

public interface Computer {
	void sale();
}


class Laptop implements Computer{
	@Override
	public void sale() {
		System.out.println("�ʼǱ�����");
	}	
}

class Desktop implements Computer{
	@Override
	public void sale() {
		System.out.println("̨ʽ����");
	}	
}

/**
 * ����������ӣ�����Ӱ��������
 * @author Administrator
 */
/*class Aad implements Computer{
	@Override
	public void sale() {
		System.out.println("ƽ�����");
	}	
}*/