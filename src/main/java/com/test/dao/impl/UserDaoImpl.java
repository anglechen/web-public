package com.test.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.test.dao.UserDao;
import com.test.domain.User;

/**
 * 用户数据库的操作类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1:3306/web-public";
		String name = "root";
		String password = "123456";
		String sql = "insert into user(name) values('test')";
		
		Connection conn = null;
		Statement statement =null;
		try {
			conn = DriverManager.getConnection(url, name, password);
			statement = conn.createStatement();
			statement.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
	}

	@Override
	public void mod(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void del(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> query(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
