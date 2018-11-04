package com.test.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.test.dao.UserDao;
import com.test.domain.User;
import com.test.utils.JdbcUtil;

/**
 * 用户数据库的操作类
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
//		String names = "",values = "";
//		//需要条件判断动态拼接
//		names += "account,password,age";
//		values += "'" + user.getAccount() + "','" + user.getPassword() 
//			+"'," +user.getAge();
		String sql = "insert into user(account,password,age) "
				+ "values('"+ user.getAccount()
				+"','"+ user.getPassword()+"'," +user.getAge() +")";
		JdbcUtil.execute(sql);
		
	}

	@Override
	public void mod(User user) {
		String sql = "update user set account = '"
				+ user.getAccount()+"',password='" 
				+user.getPassword()+"',age = " + user.getAge()
				+" where id = " + user.getId();
		JdbcUtil.execute(sql);
		
	}

	@Override
	public void del(User user) {
		String sql = "delete from user where id = " + user.getId();
		JdbcUtil.execute(sql);
		
	}

	@Override
	public List<User> query(User user) {
		String sql = "select * from user";
		List<Map<String, String>> results = JdbcUtil.executeQuery(sql);
		List<User>  returnUsers = new ArrayList<>();
		for (Map<String, String> m : results) {
			User tmpUser = new User();
			try {
				BeanUtils.populate(tmpUser, m);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			returnUsers.add(tmpUser);
		}
		return returnUsers;
	}

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
