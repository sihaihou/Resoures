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
 *	�ļ��ָ���ϲ�
 * @author Administrator
 *
 */
public class SplitFile {
	//���ָ��ļ�·��
	private String filepath;
	//���ָ��ļ���
	private String fileName;
	//���ָ��ļ���С
	private long length;
	//�ָ��Ĵ��Ŀ¼
	private String destBlockPath;
	//�ָ����
	private int size;  
	//�ָ�ÿһ���С
	private long blockSize;
	//ÿ�������
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
	 * ��ʼ������
	 */
	public void init(){
		File src = null;
		//����ļ�·��Ϊnull���߲����ļ�
		if(null==filepath||!((src=new File(filepath)).exists())){
			return;
		}
		//������ļ���
		if(src.isDirectory()){
			return;
		}
		
		//�ļ���
		this.fileName = src.getName();
		//���������ʵ�ʴ�С��ÿ���С��ÿ������
		//�ļ���С
		this.length = src.length();
		//ÿ���С
		if(this.blockSize>length){
			this.blockSize = this.length;
		}
		//����
		size = (int)Math.ceil(this.length*1.0/this.blockSize);
		//ȷ���ָ��·��
		initPathName();
	}
	/**
	 * ȷ���ļ���
	 * @param destPath
	 */
	public void initPathName(){
		for(int i=0;i<size;i++){
			this.blockpath.add(destBlockPath+"/"+this.fileName+".split"+i+".txt");
		}
	}
	
	/**
	 * �ļ��ָ�
	 * @param destPath �ļ����·��
	 * @throws IOException 
	 */
	public void split() throws IOException{
		//��ʼ��
		long beginPos = 0;
		//ʵ�ʴ�С
		long actualBlockSize = blockSize;
		//����ÿһ��Ĵ�С ��λ�á�����
		for(int i=0;i<size;i++){
			if(i==size-1){
				actualBlockSize = this.length-beginPos;
			}			
			splitDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}	
	/**
	 * �ļ��ָ�ϸ��
	 * 
	 * @param i
	 * @param beginPos
	 * @param actualBlockSize
	 * @throws IOException 
	 */
	private void splitDetail(int i, long beginPos, long actualBlockSize) throws IOException {
		//Դ�ļ�
		File src = new File(this.filepath);  
		//����ļ�
		File dest = new File(this.blockpath.get(i));
		RandomAccessFile raf = null;
		BufferedOutputStream bos= null;
		try {
				raf = new RandomAccessFile(src, "r");
				bos = new BufferedOutputStream(new FileOutputStream(dest));
				//��λ
				raf.seek(beginPos);
				//������
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
	 * �ļ��ĺϲ�
	 * @throws IOException 
	 */
	public void merge(String destPath) throws IOException{
		//����Դ
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
	 * �ļ��ĺϲ�
	 * @throws IOException 
	 */
	public void merge1(String destPath) throws IOException{
		//����Դ
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
	 * ����
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
