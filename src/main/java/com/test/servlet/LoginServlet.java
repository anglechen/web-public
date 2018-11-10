/**
 *
 */
package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.test.domain.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

/**
 * @author Administrator
 * @date 2018年5月4日 下午2:29:26
 * 
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private UserService userService = new UserServiceImpl();
	
	/**
	 * 登出用get处理
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		resp.setContentType("application/json;character=utf-8");
		PrintWriter pw = resp.getWriter();
		JSONObject json = new JSONObject();
		json.put("loginOut", "success");
		pw.write(json.toJSONString());
	}

	/**
	 * 登录post处理
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		int count = userService.login(user);
		if(count > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("name", user.getAccount());
			req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("error", "用户名或密码错误！请重试！");
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	
	

}
