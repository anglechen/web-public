package com.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {
	
	//静态块，类加载的时候只会执行一次
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/web-public";
	private static String name = "root";
	private static String password = "123456";

	/**
	 * 执行新增，修改，删除的操作
	 * @param sql
	 */
	public static void execute(String sql) {
		System.out.println(sql);
		Connection conn = null;
		Statement statement =null;
		try {
			conn = getConnection();
			statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(statement,conn);
		}
	}
	
	
	/**
	 * 执行新增，修改，删除的操作
	 * @param sql
	 */
	public static List<Map<String, String>> executeQuery(String sql) {
		System.out.println(sql);
		Connection conn = null;
		Statement statement =null;
		ResultSet resultSet = null;
//		保存所有行数据
		List<Map<String, String>> results = new ArrayList<>();
		try {
			conn = getConnection();
			statement = conn.createStatement();
			//结果集
			resultSet = statement.executeQuery(sql);
			//结果集对应表的元数据信息
			ResultSetMetaData meteData = resultSet.getMetaData();
			//返回表中一共有多少列
			int count = meteData.getColumnCount();
//			遍历表中每一行的数据，
			while(resultSet.next()) {
				//保存每一列的map对象
				Map<String, String> tempMap = new HashMap<>();
//				遍历每行中的每一列数据
				for(int i = 1; i<= count ; i++) {
//					System.out.println(
//			meteData.getColumnLabel(i) +":" + resultSet.getString(i));
					tempMap.put(meteData.getColumnLabel(i), resultSet.getString(i));
				}
				results.add(tempMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			release(statement,conn);
		}
		return results;
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void release(Statement statement, Connection conn) {
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
