package com.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("监听到容器启动，正在初始化资源。。。。");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
