package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.test.domain.User;
import com.test.listener.InitListener;
import com.test.service.UserService;
import com.test.service.annotation.Test;
import com.test.service.impl.UserServiceImpl;

@WebServlet("/users/list")
public class UserServlet extends HttpServlet {


	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter print = resp.getWriter();
		//获取缓存的用户信息，可以在此处直接调用缓存
		List<User> users = InitListener.userCache;
		//如果没有缓存就需要查询数据库
		if(users == null || users.size() == 0) {
			System.out.println("从数据库查询用户信息");
			users = userService.query(new User());
			InitListener.userCache = users;
		}
		
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("count", users.size());
		jsonObject.put("data", users);
		resp.setContentType("application/json,charset=utf-8");
		print.write(jsonObject.toJSONString());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	
	
	
	
}
