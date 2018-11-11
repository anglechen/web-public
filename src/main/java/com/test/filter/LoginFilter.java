package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/users/*")
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		System.out.println("sessionid:" + session.getId());
		Object name = session.getAttribute("name");
		if(name !=null) {
			chain.doFilter(request, response);
		}else {
			req.setAttribute("error", "请先登录后再操作");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}

}
