package com.test.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.dao.UserDao;
import com.test.domain.User;

public class UserDaoImplTest {

	@Test
	public void testAdd() {
		UserDao userDao = new UserDaoImpl();
		userDao.add(new User());
	}

	@Test
	public void testMod() {
		fail("Not yet implemented");
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
