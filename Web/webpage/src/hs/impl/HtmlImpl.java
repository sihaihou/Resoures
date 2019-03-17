package hs.impl;

import java.util.List;

import hs.dao.impl.HtmlDaoImpl;
import hs.pojo.Html;
import hs.service.impl.HtmlServicImpl;

public class HtmlImpl {
	public static List getHtmls() {
		HtmlServicImpl htmlServicImpl = new HtmlServicImpl();
		htmlServicImpl.setHtmlDao(new HtmlDaoImpl());
		List<Html> htmls = htmlServicImpl.getHtml();
		return htmls;
	}
}
