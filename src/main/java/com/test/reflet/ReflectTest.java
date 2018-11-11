package com.test.reflet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.test.domain.User;

public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz  = null;
		clazz= Class.forName("com.test.domain.User");
//		clazz = User.class;
//		User u1 = new User();
//		clazz = u1.getClass();
		System.out.println("------获取属性-------");
//		Field[] fields	= clazz.getFields();
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields) {
			System.out.println(f.getName());
		}
		System.out.println("--------获取方法-------");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		System.out.println("--------方法使用-------");
		User u = (User) clazz.newInstance();
		User u2 = new User();
		
		System.out.println("反射实例化对象："+u);
		
		Method setM = clazz.getMethod("setName", String.class);
		
		setM.invoke(u, "张三");
		u2.setName("张三");
		
		System.out.println("发射赋值:"+ u);
		
		
		
		System.out.println("user类的类加载器：" + clazz.getClassLoader());
		
		System.out.println("user类的类加载器的父类：" + clazz.getClassLoader().getParent());
		
		System.out.println("user类的类加载器的父类的父类：" + clazz.getClassLoader().getParent().getParent());
		
		
		
		
		
	}
}
