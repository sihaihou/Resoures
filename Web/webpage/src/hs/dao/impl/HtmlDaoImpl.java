package hs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hs.dao.CourseDao;
import hs.dao.HtmlDao;
import hs.pojo.Html;
import hs.util.JDBC;

public class HtmlDaoImpl implements HtmlDao{
	@Override
	public List<Html> getHtml() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Html> htmls = null;
		try {
			conn = JDBC.getConnection();
			String sql = "select * from html";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			htmls = new ArrayList<Html>();
			while(rs.next()) {
				Html html = new Html();
				html.setId(rs.getInt("id"));
				html.setName(rs.getString("name"));
				htmls.add(html);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(rs, ps, conn);
		}
		return htmls;
	}
}
