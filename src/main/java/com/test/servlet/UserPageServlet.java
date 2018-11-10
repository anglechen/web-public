/**
 *
 */
package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2018年5月4日 下午3:18:22
 * 
 */
@WebServlet("/user/index")
public class UserPageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/user/user.jsp").forward(req, resp);
	}
	
	
}
