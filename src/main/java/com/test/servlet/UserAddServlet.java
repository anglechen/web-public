package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.domain.User;
import com.test.listener.InitListener;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

@WebServlet("/users/add")
public class UserAddServlet extends HttpServlet{
	
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		PrintWriter print = resp.getWriter();
		//一个个参数获取
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		//获取请求对象中的所有参数
		Map parameters = req.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, parameters);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
//		JSONObject.toJavaObject((JSONObject)JSONObject.toJSON(parameters), User.class);
		userService.add(user);
		//更新缓存
		InitListener.userCache = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		resp.setContentType("application/json,charset=utf-8");
		print.write(jsonObject.toJSONString());
	}
}
