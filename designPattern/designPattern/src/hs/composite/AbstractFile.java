package hs.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * �����ļ�
 * @author Administrator
 */
public interface AbstractFile {
	/**
	 * ɱ��
	 */
	void killVirus();
}

/**
 * ��ɱ  ͼ���ļ�
 * @author Administrator
 */
class ImageFile implements AbstractFile{
	private String name;
	public ImageFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---ͼ���ļ�:"+name+"  ���в�ɱ��");
	}
}
/**
 * ��ɱ  �ı��ļ�
 * @author Administrator
 */
class TextFile implements AbstractFile{
	private String name;
	public TextFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---�ı��ļ�:"+name+"  ���в�ɱ��");
	}
}
/**
 * ��ɱ  ��Ƶ�ļ�
 * @author Administrator
 */
class VideoFile implements AbstractFile{
	private String name;
	public VideoFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---��Ƶ�ļ�:"+name+"  ���в�ɱ��");
	}
}
/**
 * �ļ���
 * @author Administrator
 */
class Foder implements AbstractFile{
	private String name;
	/**
	 * ����������������������ṹ�µ��ֽڵ�
	 */
	private List<AbstractFile> list=new ArrayList<AbstractFile>();
	public Foder(String name) {
		this.name = name;
	}
	public void add(AbstractFile file){
		list.add(file);
	}
	public void remove(AbstractFile file){
		list.remove(file);
	}
	public AbstractFile getChild(int index){
		return  list.get(index);
		
	}
	@Override
	public void killVirus() {
		System.out.println("---�ļ���:"+name+"  ���в�ɱ��");
		for(AbstractFile file:list){
			file.killVirus();
		}
	}
}
