package hs.randomAccessFile10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import hs.close.CloseUtil;
/**
 *	文件分割与合并
 * @author Administrator
 *
 */
public class SplitFile {
	//被分割文件路径
	private String filepath;
	//被分割文件名
	private String fileName;
	//被分割文件大小
	private long length;
	//分割后的存放目录
	private String destBlockPath;
	//分割块数
	private int size;  
	//分割每一块大小
	private long blockSize;
	//每块的名称
	private List<String> blockpath;
	public SplitFile() {
		blockpath = new ArrayList<String>();
	}	
	public SplitFile(String filepath,String destBlockPath) {
		this(filepath,destBlockPath,1024);
	}
	public SplitFile(String filepath,String destBlockPath, long blockSize) {
		this();
		this.filepath = filepath;
		this.destBlockPath=destBlockPath;
		this.blockSize = blockSize;
		init();
	}
	/**
	 * 初始化操作
	 */
	public void init(){
		File src = null;
		//如果文件路径为null或者不是文件
		if(null==filepath||!((src=new File(filepath)).exists())){
			return;
		}
		//如果是文件夹
		if(src.isDirectory()){
			return;
		}
		
		//文件名
		this.fileName = src.getName();
		//计算块数、实际大小、每块大小、每块名称
		//文件大小
		this.length = src.length();
		//每块大小
		if(this.blockSize>length){
			this.blockSize = this.length;
		}
		//块数
		size = (int)Math.ceil(this.length*1.0/this.blockSize);
		//确定分割保存路径
		initPathName();
	}
	/**
	 * 确定文件名
	 * @param destPath
	 */
	public void initPathName(){
		for(int i=0;i<size;i++){
			this.blockpath.add(destBlockPath+"/"+this.fileName+".split"+i+".txt");
		}
	}
	
	/**
	 * 文件分割
	 * @param destPath 文件存放路径
	 * @throws IOException 
	 */
	public void split() throws IOException{
		//起始点
		long beginPos = 0;
		//实际大小
		long actualBlockSize = blockSize;
		//计算每一块的大小 、位置、索引
		for(int i=0;i<size;i++){
			if(i==size-1){
				actualBlockSize = this.length-beginPos;
			}			
			splitDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}	
	/**
	 * 文件分割细节
	 * 
	 * @param i
	 * @param beginPos
	 * @param actualBlockSize
	 * @throws IOException 
	 */
	private void splitDetail(int i, long beginPos, long actualBlockSize) throws IOException {
		//源文件
		File src = new File(this.filepath);  
		//存放文件
		File dest = new File(this.blockpath.get(i));
		RandomAccessFile raf = null;
		BufferedOutputStream bos= null;
		try {
				raf = new RandomAccessFile(src, "r");
				bos = new BufferedOutputStream(new FileOutputStream(dest));
				//定位
				raf.seek(beginPos);
				//缓冲区
				byte[] buffer = new byte[1024];
				int len = 0;
				while(-1!=(len=raf.read(buffer))){
					if(actualBlockSize-len>0){
						bos.write(buffer,0,len);
						actualBlockSize -= len; 
					}else{
						bos.write(buffer,0,(int)actualBlockSize);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {		
				CloseUtil.close(bos,raf);
			}
	}
	
	/**
	 * 文件的合并
	 * @throws IOException 
	 */
	public void merge(String destPath) throws IOException{
		//创建源
		File dest = new File(destPath);
		BufferedOutputStream bos = null;
		try {
			bos=new BufferedOutputStream(new FileOutputStream(dest,true));
			BufferedInputStream bis = null;
			for(int i=0;i<this.blockpath.size();i++){
				bis = new BufferedInputStream(new FileInputStream(new File(this.blockpath.get(i))));
				byte[] buffer = new byte[1024];
				int len = 0;
				while(-1!=(len=bis.read(buffer))){
					bos.write(buffer,0,len);
				}	
				bos.flush();
				CloseUtil.close(bis);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			CloseUtil.close(bos);
		}
	}
	/**
	 * 文件的合并
	 * @throws IOException 
	 */
	public void merge1(String destPath) throws IOException{
		//创建源
		File dest = new File(destPath);
		BufferedOutputStream bos = null;
		SequenceInputStream sis = null;
		try {
			Vector<InputStream> vt = new Vector<InputStream>();
			for(int i=0;i<this.blockpath.size();i++){
				vt.add(new BufferedInputStream(new FileInputStream(new File(this.blockpath.get(i)))));
			}
				bos=new BufferedOutputStream(new FileOutputStream(dest,true));			
				sis = new SequenceInputStream(vt.elements());
				byte[] buffer = new byte[1024];
				int len = 0;
				while(-1!=(len=sis.read(buffer))){
					bos.write(buffer,0,len);
				}	
				bos.flush();
				CloseUtil.close(sis);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			CloseUtil.close(bos);
		}
	}
	
	/**
	 * 测试
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		SplitFile split = new SplitFile("E:/test/06.txt","E:/test/split",50);
		System.out.println(split.size);
		split.split();
		split.merge("E:/test/split/merge.txt");
		split.merge1("E:/test/split/merge1.txt");
	}
}
