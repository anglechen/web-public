package com.test.service.impl;

import java.util.List;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.domain.User;
import com.test.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void mod(User user) {
		userDao.mod(user);
		
	}

	@Override
	public void del(User user) {
		userDao.del(user);
		
	}

	@Override
	public List<User> query(User user) {
		return userDao.query(user);
	}

	@Override
	public int login(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
