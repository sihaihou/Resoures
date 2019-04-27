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
 * hql��ѯ����
 * @author Administrator
 *
 */
public class GetTest {
	//��ѯ��������
	@Test
	public void testQuery1(){	
		 // ��ѯ��������
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������
		String hql = "select name from Book"; 
		Query query = session.createQuery(hql);
		//list()�������ز�ѯ���
		//���ؽ������ ���Ǹ��ݲ�ѯ���о�����
		List<String> list = query.list();
		for(String BookName:list){
			System.out.println(BookName);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//��ѯ�������
	@Test
	public void testQuery2(){	
		 // ��ѯ������������ļ۸�
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Object[]> list = session.createQuery("select name,price from Book").list();
		for(Object[] objs:list){
			System.out.println(objs[0]+"---"+objs[1]);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//��ѯ�����ʱ������ѯ�����װΪ���󼯺�
	@Test
	public void testQuery3(){	
		 // ��ѯ������������ļ۸�
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("select new Book(name,price) from Book").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//������ʹ��
	@Test
	public void testQuery4(){	
		 // ��ѯ������������ļ۸�
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("select new Book(b.name,b.price) from Book as b").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//��ѯ������
	@Test
	public void testQuery5(){	
		 // ��ѯ��������
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("from Book").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
	//hql��ѯ����ʹ�� * ����ʹ�ñ���
	@Test
	public void testQuery6(){	
		 // ��ѯ��������
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("select b from Book b").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//������ѯ 
	//setInteger 
	@Test
	public void testQuery7(){	
		 // ��ѯ��������
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("select b from Book b where id < ?")
				.setInteger(0, 3).list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//������ѯ ռλ�� �� 0 ��ʼ
	//setParameter ��������ѯ����
	@Test
	public void testQuery8(){	
		 // ��ѯ�������� 
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("select b from Book b where id < ?")
				.setParameter(0, 3).list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//������ѯ��������ѯ��--�����������������ƣ���ð�ſ�ͷ������ƣ����ò���ʱ��ֻ��ָ����
	@Test
	public void testQuery9(){	
		 // ��ѯ�������� 
		 // ����Query����	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		//book ��д��ָ���� hs.pojo.Book��
		//name ָ����Book���������		
		//list()�������ز�ѯ���
		//��ѯ�����ʱ�����ؽ�������鼯�� ��������Ԫ�ص��������ɲ�ѯ���о�����
		List<Book> list = session.createQuery("select b from Book b where id <:id")
				.setParameter("id", 3).list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//��ҳ��ѯ
	@Test
	public void testQuery10(){	
		 // ��ѯ�������� 
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Book> list = session.createQuery("from Book b")
				.setFirstResult(0) //��ʼ��ʾ�ļ�¼�±�(currentpage-1)*pageSize
				.setMaxResults(3) //����ÿҳ��¼�� pageSize
				.list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//�ۺϲ�ѯ       ͳ�Ʋ�ѯ
	//���Ψһ
	@Test
	public void testQuery11(){	
		 // ��ѯͼ������
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Number count= (Number) session.createQuery("select count(b.name) from Book b")
				      .uniqueResult();	//���Ψһ
		System.out.println("ͼ��������"+count.intValue());		
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//�ۺϲ�ѯ       ͳ�Ʋ�ѯ
	//���Ψһ
	@Test
	public void testQuery12(){	
		 // ��ѯ���ͼ��۸�
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object count=  session.createQuery("select max(b.price) from Book b")
						.uniqueResult();
		System.out.println("�����۸�"+count);		
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//�����ѯ
	@Test
	public void testQuery13(){	
		 // ��ѯÿ��ͼ�����͵�����
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Object[]> list=   session.createQuery("select b.category.name,count(b.id) from Book b group by b.category.name").list();
		for(Object[] objs:list){
			System.out.println(objs[0]+"---"+objs[1]); 
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//�����ѯ	
	@Test
	public void testQuery14(){	
		 // ��ѯͼ��۸���
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Book> list= session.createQuery("from Book order by price desc").list();
		for(Book b:list){
			System.out.println(b); 
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//���󵼺�     ���Ӳ�ѯ
	@Test
	public void testQuery15(){	
		 // ��ѯ"����"���鼮��Ϣ
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Book b where b.category.name=:name";
		hql = "select b from Book b join b.category c where c.name=:name"; 
		hql = "select b from Book b inner join b.category c where c.name=:name"; 
		List<Book> list= session.createQuery(hql)
				.setString("name","����")
				.list();
		for(Book b:list){
			System.out.println(b); 
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//��\��������
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
	 * ��������ʹ��     ---���˲�ѯ--Ϊ��ѯ����ĳЩ����
	 *   1�����������
	 *   2��ʹ��:������
	 *   3���ڲ�ѯ��ʱ��ʹ�ù�������Ч
	 *   
	 *   �����ڣ�10hibernate4_double_one_to_many/test/hs/test/GetTest
	 */
	@Test
	public void testQuery17(){	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();		
		//���ù�����
		session.enableFilter("studentFilter").setParameter("id", 3);
		List<Book> list = session.createQuery("from Book").list();
		for(Book b:list){
			System.out.println(b);
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
	//������ѯNamedQuery
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
		//���ز�ѯ SQL��ѯ
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
		//�����ѯ��������
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
		//�����ѯ  Critera��ѯ
		//��ѯ���󼯺�
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
		//����
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
		//like��ѯ
		@Test
		public void testQuery24(){
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			List<Book> list =session.createCriteria(Book.class)
					//.add(Restrictions.like("name", "��%"))
					//.add(Restrictions.like("name", "��", MatchMode.EXACT))
					//ilike ignoreCase like���Դ�Сд
					.add(Restrictions.ilike("name", "%��%"))
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
					//.add(Restrictions.like("name", "��%"))
					//.add(Restrictions.like("name", "��", MatchMode.EXACT))
					//ilike ignoreCase like���Դ�Сд
					.add(Restrictions.or(Restrictions.eq("id", 1)
							, Restrictions.lt("price", 60.0)))
					.list();
					for(Book b:list){
						System.out.println(b+"-"+b.getCategory().getId());
					}
			tx.commit();
			HibernateUtil.closeSession();
		}
		//����
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
		//ͶӰ--����
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
		//����
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
		//example��ѯ
		@Test
		public void testQuery30(){
			Session session = HibernateUtil.getSession();
			Book book = new Book();
			book.setName("������ƫ��");
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
