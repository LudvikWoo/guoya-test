package com.guoyasoft.tools.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcOracleTools {
	public static Connection getConnection() {
		// 第1步：选择驱动，有mysql的，有orace，类似不同版本的浏览器
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 第2步：提供链接地址，哪台主机，哪个应用port，哪个实例（类似tomcat的应用名）
		String url = "jdbc:oracle:thin:@47.98.226.232:3308/guoya_test";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
		// 第3步：登录，用户名、密码
		String username = "root";
		String password = "123456";
		// 第4步：建立链接，固定写法
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static int update(String sql) {
		System.out.println(sql);
		int result=0;
		// 第1步：建立数据库链接
		Connection conn = JdbcOracleTools.getConnection();
		// 第2步：写SQL魔板
		// 第3步：按照真实数据生成执行SQL
		Statement st;
		ResultSet set;
		try {
			st=conn.createStatement();
			// 执行拼装好的sql,如果是更新，则返回更新条数
			result = st.executeUpdate(sql);
			// 关闭链接
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
