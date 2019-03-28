package hs.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import hs.dao.UserDao;
import hs.pojo.User;
import hs.util.MyBatisUtil;
/**
 * ∂ØÃ¨sql≤È—Ø
 * @author Administrator
 *
 */
public class MybatisTest {
	@Test
	public void testSelectUserByIf(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
			User user = new User("—Ô",18);
			//User user = new User("",18);
			//User user = new User("",0);
			
			List<User> list = mapper.selectUserByIf(user);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void testSelectUserByWhere(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
			//User user = new User("—Ô",18);
			User user = new User("",18);
//			User user = new User("",0);
			
			List<User> list = mapper.selectUserByWhere(user);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	@Test
	public void testSelectUserByChoose(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
//			User user = new User("—Ô",18);
			User user = new User("",18);
//			User user = new User("",0);
			
			List<User> list = mapper.selectUserByChoose(user);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	@Test
	public void testSelectUserByForeach(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
			int[] id = {1,3,4,6};
			
			List<User> list = mapper.selectUserByForeach(id);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	@Test
	public void testSelectUserByForeach2(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
			List<Integer> id = new ArrayList<Integer>();
			id.add(1);
			id.add(3);
			List<User> list = mapper.selectUserByForeach2(id);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	@Test
	public void testSelectUserByForeach3(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
			User user1 = new User();
			user1.setId(2);
			User user2 = new User();
			user2.setId(3);
			List<User> user = new ArrayList<User>();
			user.add(user1);
			user.add(user2);
			
			List<User> list = mapper.selectUserByForeach3(user);
			for(User u:list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	/**
	 * sql∆¨∂Œ
	 */
	@Test
	public void testSelectUserBySqlFragment(){
		SqlSession sqlSession = null;
		try{
			sqlSession = MyBatisUtil.getSqlSession();
			UserDao	mapper = sqlSession.getMapper(UserDao.class);
			User user1 = new User();
			user1.setId(2);
			User user2 = new User();
			user2.setId(3);
			List<User> user = new ArrayList<User>();
			user.add(user1);
			user.add(user2);
			
			List<User> list = mapper.selectUserBySqlFragment(user);
			for(User u: list){
				System.out.println(u);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
}
