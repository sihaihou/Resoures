package hs.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象文件
 * @author Administrator
 */
public interface AbstractFile {
	/**
	 * 杀毒
	 */
	void killVirus();
}

/**
 * 查杀  图像文件
 * @author Administrator
 */
class ImageFile implements AbstractFile{
	private String name;
	public ImageFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---图形文件:"+name+"  进行查杀！");
	}
}
/**
 * 查杀  文本文件
 * @author Administrator
 */
class TextFile implements AbstractFile{
	private String name;
	public TextFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---文本文件:"+name+"  进行查杀！");
	}
}
/**
 * 查杀  视频文件
 * @author Administrator
 */
class VideoFile implements AbstractFile{
	private String name;
	public VideoFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("---视频文件:"+name+"  进行查杀！");
	}
}
/**
 * 文件夹
 * @author Administrator
 */
class Foder implements AbstractFile{
	private String name;
	/**
	 * 定义容器，用来存放容器结构下的字节点
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
		System.out.println("---文件夹:"+name+"  进行查杀！");
		for(AbstractFile file:list){
			file.killVirus();
		}
	}
}
