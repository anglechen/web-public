package com.test.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.domain.User;
import com.test.utils.JdbcUtil;

@WebListener
public class InitListener implements ServletContextListener{
	
	public static List<User> userCache = new ArrayList<>();
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String sql = "select * from user";
		List<Map<String, String>> results = JdbcUtil.executeQuery(sql);
		for (Map<String,String> m : results) {
			//通过json的方式把map转换为json，然后再把json对象转换为javabean
			User tmpUser =  JSONObject.toJavaObject((JSON)JSON.toJSON(m), User.class);
			userCache.add(tmpUser);
		}
		System.out.println("监听到容器启动，正在加载用户缓存资源。。。。");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("这里是监听器的销毁动作");
	}

}
