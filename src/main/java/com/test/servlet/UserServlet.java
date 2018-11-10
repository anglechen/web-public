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
		List<User> users = userService.query(new User());
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
