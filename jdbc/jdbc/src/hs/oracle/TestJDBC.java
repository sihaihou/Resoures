package hs.oracle;

import java.lang.management.ManagementPermission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=(Connection) DriverManager.getDriver("jdbc:oracle:thin:@localhost:1521:orcl");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
