package hs.test;

import java.util.ArrayList;
import java.util.List;

import hs.dao.impl.HtmlDaoImpl;
import hs.service.impl.HtmlServicImpl;

public class Test {
	public static void main(String[] args) {
		List parsonList = new ArrayList();
		HtmlServicImpl htmlserviceimpl = new HtmlServicImpl();
		htmlserviceimpl.setHtmlDao(new HtmlDaoImpl());
		for(int i=0;i< htmlserviceimpl.getHtml().size();i++){
			parsonList.add(htmlserviceimpl.getHtml().get(i).getName());
		}
		
	}
}
