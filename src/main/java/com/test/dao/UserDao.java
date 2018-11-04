package com.test.dao;

import java.util.List;

import com.test.domain.User;

public interface UserDao {
	
	public void add(User user);
	
	public void mod(User user);
	
	public void del(User user);
	
	public List<User> query(User user);
	
	public int login(User user);
	
	
}
