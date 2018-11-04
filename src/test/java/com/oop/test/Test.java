package com.oop.test;

import com.test.domain.User;

public class Test {
	
	
	
	public static void main(String[] args) {
//		testString();
		testEquals();
	}
	
	public static void testEquals() {
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		System.out.println("a==b : " +  (a == b));
		System.out.println("a==c:" + (a == c));
		System.out.println("a equals b" + (a.equals(b)));
		System.out.println("a equals c " + (a.equals(c)));
		
		
		User u1 = new User();
		u1.setName("张三");
		User u2 = new User();
		u2.setName("张三");
		System.out.println("u1 == u2:" + (u1 == u2));
		System.out.println(" u1 equals u2 :" +u1.equals(u2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public static void testString() {
		String a = "abc";
		StringBuffer b = new StringBuffer("abc");
		
		long stringStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			a += "abc";
		}
		long stringEnd = System.currentTimeMillis();
		System.out.println("string : "+ ( stringEnd - stringStart));
		
		
		long stringBufStart = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			b.append("abc");
		}
		long stringBufEnd = System.currentTimeMillis();
		System.out.println("stringBuf : "+ ( stringBufEnd - stringBufStart));
		
		
		
	}
}
