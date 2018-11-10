package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.dao.UserDao;
import com.test.domain.User;
import com.test.utils.JdbcUtil;

/**
 * 用户数据库的操作类
 * @author Administrator
 * 省略--动态sql条件构建（需要自己去拼接sql语句）  
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
		for (Map<String,String> m : results) {
			//通过json的方式把map转换为json，然后再把json对象转换为javabean
			User tmpUser =  JSONObject.toJavaObject((JSON)JSON.toJSON(m), User.class);
			returnUsers.add(tmpUser);
		}
		return returnUsers;
	}

	@Override
	public int login(User user) {
		String sql = "select count(1) as userCount from user"
				+ " where account = '" + user.getAccount() +"' and password = '"
				+user.getPassword() +"'";
		//省略了null判断
		List<Map<String, String>> results = JdbcUtil.executeQuery(sql);
		String count = results.get(0).get("userCount");
		return Integer.parseInt(count);
	}
	
	
	
	
	
	
	
	
	

}
