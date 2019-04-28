package hs.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 测试Object[]封装一条数据
 *   并放在List容器中
 * @author Administrator
 */
public class Sorm1 {
	public static void main(String[] args) {
		Connection c=JDBCUtil.getMysqlConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Object[]> list =new ArrayList<Object[]>();
		try {
			ps=c.prepareStatement("select name,salary,birthday,age from emp where id>=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();		
			while(rs.next()){
				//System.out.println(rs.getString(1)+rs.getInt(2)+rs.getTimestamp(3)+rs.getInt(4));
				Object[] objs=new Object[4];
				objs[0]=rs.getObject(1);
				objs[1]=rs.getObject(2);
				objs[2]=rs.getObject(3);
				objs[3]=rs.getObject(4);
				list.add(objs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}
		for(Object[] objs:list){
			System.out.println(objs[0]+"\t"+objs[1]+"\t"+objs[2]+"\t"+objs[3]);
		}
	}
}
