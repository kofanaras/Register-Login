package com.mk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static Connection conn;
	private static final String url = "jdbc:postgresql://localhost/loginDB";
	private static final String user = "postgres";
	private static final String pass = "1234";

	private static Connection getConnection() {
		if (conn != null) {
			return conn;

		}
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static ResultSet executeQuery(String sql) throws Exception {
		Statement st = getConnection().createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;

	}
	
	public static void executeUpdate(String sql) throws Exception {
		Statement st = getConnection().createStatement();
		st.executeUpdate(sql);
	}

}
