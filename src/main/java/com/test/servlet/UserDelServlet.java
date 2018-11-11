package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.test.domain.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

@WebServlet("/users/del")
public class UserDelServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();
			
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ids = req.getParameter("ids");
		String[] strIds = ids.split(",");
		
		for(String i : strIds) {
			User user = new User();
			user.setId(Integer.parseInt(i));
			userService.del(user);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
	
	}
	
	
}
