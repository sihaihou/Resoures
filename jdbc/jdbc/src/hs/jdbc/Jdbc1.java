package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc1 {
	public static void main(String[] args) {
		Connection c=null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//��������(���Ӷ����ڲ���ʵ������һ��socket������һ��Զ�̵����ӣ��ȽϺ�ʱ������Connection�����һ��Ҫ��)
			//���������У�Ϊ�����Ч�ʣ�����������ӳ����������Ӷ���
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			long end=System.currentTimeMillis();
			System.out.println(c);
			System.out.println("�������Ӻ�ʱ:"+(end-start)+"����");
		} catch (SQLException e) {
				e.printStackTrace();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			/*try {
				if(c!=null){
				c.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			JDBCUtil.close(c);
		}
	}
}
