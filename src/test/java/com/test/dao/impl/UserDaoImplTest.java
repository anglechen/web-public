package com.test.dao.impl;

import static org.junit.Assert.*;

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
	}

}
