package hs.service.impl;

import java.util.List;

import hs.dao.HtmlDao;
import hs.pojo.Html;
import hs.service.HtmlService;

public class HtmlServicImpl implements HtmlService{
	private HtmlDao htmlDao;
	
	public void setHtmlDao(HtmlDao htmlDao) {
		this.htmlDao = htmlDao;
	}
	@Override
	public List<Html> getHtml() {
		List<Html> htmls = htmlDao.getHtml();
		return htmls;
	}
}
