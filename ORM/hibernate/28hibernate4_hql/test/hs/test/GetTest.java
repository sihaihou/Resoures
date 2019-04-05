package hs.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import hs.pojo.Book;
import hs.util.HibernateUtil;
/**
 * hql查询语言
 * @author Administrator
 *
 */
public class GetTest {
	//查询单个属性
	@Test
	public void testQuery1(){	
		 // 查询所有书名
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名
		String hql = "select name from Book"; 
		Query query = session.createQuery(hql);
		//list()方法返回查询结果
		//返回结果的类 型是根据查询的列决定的
		List<String> list = query.list();
		for(String BookName:list){
			System.out.println(BookName);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//查询多个属性
	@Test
	public void testQuery2(){	
		 // 查询所有书名和书的价格
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Object[]> list = session.createQuery("select name,price from Book").list();
		for(Object[] objs:list){
			System.out.println(objs[0]+"---"+objs[1]);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//查询多个列时，将查询结果封装为对象集合
	@Test
	public void testQuery3(){	
		 // 查询所有书名和书的价格
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("select new Book(name,price) from Book").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//别名的使用
	@Test
	public void testQuery4(){	
		 // 查询所有书名和书的价格
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("select new Book(b.name,b.price) from Book as b").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//查询所有列
	@Test
	public void testQuery5(){	
		 // 查询所有属性
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("from Book").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//hql查询不能使用 * 可以使用别名
	@Test
	public void testQuery6(){	
		 // 查询所有属性
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("select b from Book b").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//条件查询 
	//setInteger 
	@Test
	public void testQuery7(){	
		 // 查询所有属性
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("select b from Book b where id < ?")
				.setInteger(0, 3).list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//条件查询 占位符 从 0 开始
	//setParameter 不用理会查询类型
	@Test
	public void testQuery8(){	
		 // 查询所有属性 
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("select b from Book b where id < ?")
				.setParameter(0, 3).list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//条件查询；命名查询：--设置条件参数的名称，以冒号开头后跟名称，设置参数时，只需指定名
	@Test
	public void testQuery9(){	
		 // 查询所有属性 
		 // 创建Query对象	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book 大写：指的是 hs.pojo.Book类
		//name 指的是Book类的属性名		
		//list()方法返回查询结果
		//查询多个列时，返回结果是数组集合 ，数组中元素的类型是由查询的列决定的
		List<Book> list = session.createQuery("select b from Book b where id <:id")
				.setParameter("id", 3).list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//分页查询
	@Test
	public void testQuery10(){	
		 // 查询所有属性 
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Book> list = session.createQuery("from Book b")
				.setFirstResult(0) //开始显示的记录下标(currentpage-1)*pageSize
				.setMaxResults(3) //设置每页记录数 pageSize
				.list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//聚合查询       统计查询
	//结果唯一
	@Test
	public void testQuery11(){	
		 // 查询图书总数
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Number count= (Number) session.createQuery("select count(b.name) from Book b")
				      .uniqueResult();	//结果唯一
		System.out.println("图书总数："+count.intValue());		
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//聚合查询       统计查询
	//结果唯一
	@Test
	public void testQuery12(){	
		 // 查询最贵图书价格
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object count=  session.createQuery("select max(b.price) from Book b")
						.uniqueResult();
		System.out.println("最贵书价格："+count);		
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//分组查询
	@Test
	public void testQuery13(){	
		 // 查询每种图书类型的数量
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Object[]> list=   session.createQuery("select b.category.name,count(b.id) from Book b group by b.category.name").list();
		for(Object[] objs:list){
			System.out.println(objs[0]+"---"+objs[1]); 
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//排序查询	
	@Test
	public void testQuery14(){	
		 // 查询图书价格降序
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Book> list= session.createQuery("from Book order by price desc").list();
		for(Book b:list){
			System.out.println(b); 
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//对象导航     连接查询
	@Test
	public void testQuery15(){	
		 // 查询"仙侠"的书籍信息
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Book b where b.category.name=:name";
		hql = "select b from Book b join b.category c where c.name=:name"; 
		hql = "select b from Book b inner join b.category c where c.name=:name"; 
		List<Book> list= session.createQuery(hql)
				.setString("name","仙侠")
				.list();
		for(Book b:list){
			System.out.println(b); 
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//左\右外链接
	@Test
	public void testQuery16(){	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql="select c.name,b.name from Category c left outer join c.books b";
		List<Object[]> list = session.createQuery(hql).list();
		for(Object[] objs:list){
			System.out.println(objs[0]+"---"+objs[1]);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	/**
	 * 过滤器的使用     ---过滤查询--为查询加上某些条件
	 *   1，定义过滤器
	 *   2，使用:加条件
	 *   3，在查询的时候，使得过滤器生效
	 *   
	 *   链接于：10hibernate4_double_one_to_many/test/hs/test/GetTest
	 */
	@Test
	public void testQuery17(){	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();		
		//启用过滤器
		session.enableFilter("studentFilter").setParameter("id", 3);
		List<Book> list = session.createQuery("from Book").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//命名查询NamedQuery
		@Test
		public void testQuery17_2(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.getNamedQuery("getByCategoryId")
							.setInteger("id", 2)
							.list();
			for(Book b:list){
				System.out.println(b);
			}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//本地查询 SQL查询
		@Test
		public void testQuery18(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String sql="select Name,Price from BOOK";
			List<Object[]> list =session.createSQLQuery(sql)
							.list();
			for(Object[]  b:list){
				System.out.println(b[0]+"-"+b[1]);
			}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//如果查询是所有列
		@Test
		public void testQuery19(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String sql="select * from BOOK";
			List<Book> list =session.createSQLQuery(sql)
							.addEntity(Book.class)
							.list();
			for(Book b:list){
				System.out.println(b);
			}
			tx.commit();
			HibernateUtil.closeSession();
		}
		@Test
		public void testQuery20(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.getNamedQuery("getAll")
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//对象查询  Critera查询
		//查询对象集合
		@Test
		public void testQuery21(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.createCriteria(Book.class)
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//条件
		@Test
		public void testQuery22(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			
			List<Book> list =session.createCriteria(Book.class)
					.add(Restrictions.eq("id", 1))
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//in
		@Test
		public void testQuery23(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Integer> inl = new ArrayList<Integer>();
			inl.add(1);
			inl.add(3);
			List<Book> list =session.createCriteria(Book.class)
					.add(Restrictions.in("id", inl))
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//like查询
		@Test
		public void testQuery24(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.createCriteria(Book.class)
					//.add(Restrictions.like("name", "中%"))
					//.add(Restrictions.like("name", "的", MatchMode.EXACT))
					//ilike ignoreCase like忽略大小写
					.add(Restrictions.ilike("name", "%的%"))
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//or
		@Test
		public void testQuery25(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.createCriteria(Book.class)
					//.add(Restrictions.like("name", "中%"))
					//.add(Restrictions.like("name", "的", MatchMode.EXACT))
					//ilike ignoreCase like忽略大小写
					.add(Restrictions.or(Restrictions.eq("id", 1)
							, Restrictions.lt("price", 60.0)))
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//排序
		@Test
		public void testQuery26(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.createCriteria(Book.class)
					.addOrder(Order.asc("price"))
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//投影--函数
		@Test
		public void testQuery27(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			Object count =session.createCriteria(Book.class)
					.setProjection(Projections.rowCount())
					.uniqueResult();
			System.out.println(count);
			tx.commit();
			HibernateUtil.closeSession();
		}
		@Test
		public void testQuery28(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Object[]> objs =session.createCriteria(Book.class)
					.setProjection(Projections.projectionList()
							.add(Projections.max("price"))
							.add(Projections.avg("price"))
							)
					.list();
			for(Object[] obj:objs){
				System.out.println(obj[0]+"---"+obj[1]);
			}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//分组
		@Test
		public void testQuery29(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Object[]> objs =session.createCriteria(Book.class,"b")
					.createCriteria("b.category", "c")
					.setProjection(Projections.projectionList()
							.add(Projections.rowCount())
							.add(Projections.groupProperty("c.name"))
							)
					.list();
			for(Object[] obj:objs){
				System.out.println(obj[0]+"---"+obj[1]);
			}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//example查询
		@Test
		public void testQuery30(){
			Session session = HibernateUtil.getSession();
			Book book = new Book();
			book.setName("傲慢与偏见");
			book.setPrice(80);
			Transaction tx = session.beginTransaction();
			List<Book> list =session.createCriteria(Book.class)
					.add(Example.create(book))
					.list();
			for(Book b:list){
				System.out.println(b+"-"+b.getCategory().getId());
			}
			tx.commit();
			HibernateUtil.closeSession();
		}
}
