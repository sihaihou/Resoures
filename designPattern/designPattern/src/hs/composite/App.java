package hs.composite;

public class App {
	public static void main(String[] args) {
		AbstractFile f2,f3,f4,f5;
		Foder f1=new Foder("�ҵ��ļ�");
		f2=new ImageFile("  �ҵ�ͷ��.jpg");
		f3 =new TextFile("  hello.text");
		f1.add(f2);
		f1.add(f3);
		Foder f6=new Foder("�ҵ���Ƶ");
		f4=new VideoFile("  �������");
		f5=new VideoFile("  ���Ӣ�۴�");
		f6.add(f4);
		f6.add(f5);
		f1.add(f6);
		
		f2.killVirus();
		System.out.println("-------------------------");
		f1.killVirus();
		System.out.println("-------------------------");
		f6.killVirus();
	}
}
