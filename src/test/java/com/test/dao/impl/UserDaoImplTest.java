package com.test.dao.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.dao.UserDao;
import com.test.domain.User;

public class UserDaoImplTest {

	@Test
	public void testAdd() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setAccount("admin");
		user.setPassword("123456");
		user.setAge(18);
		userDao.add(user);
	}

	@Test
	public void testMod() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setAccount("test");
		user.setPassword("test");
		user.setAge(18);
		user.setId(2);
		userDao.mod(user);
	}

	@Test
	public void testDel() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setId(1);
		userDao.del(user);
	}

	@Test
	public void testQuery() {
	
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		List<User> lists = userDao.query(user);
		for(User u : lists) {
			System.out.println(u);
		}
	}

	@Test
	public void testLogin() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setAccount("abc' or '1'='1");
		user.setPassword("e10adc3949ba59abbe56e057f20f883e");
		int count = userDao.login(user);
		System.out.println(count);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList<>();
		list.add("22");
		list.add(122);
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void test()  throws Exception {
		try {
			int i = 1/0;
		} catch (Exception e) {
//			System.out.println("除数不能为0");
			throw new Exception("除数不能为0");
		}
		System.out.println("end");
		throw new Exception("除数不能为0");
		
	}

}
