package hs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hs.util.HibernateSessionFactory;

public class OpenSessionInView implements Filter{
	public void destroy() {
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	public void doFilter(ServletRequest requst, ServletResponse respones, FilterChain chain)
			throws IOException, ServletException {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			chain.doFilter(requst, respones);
			//servlet/action --->serive -->dao -->getSession-->servlet/action-->jsp
			tx.commit();
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
}
