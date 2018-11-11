package com.test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadBusiness {
	
	public static int count = 0;
	private Object obj = new Object();
	
	/**
	 * synchronized 可以修饰方法，代码块
	 */
	public   void test() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (obj) {
				count++;
			}
			
			
			
			System.out.println(Thread.currentThread().getName() + "正在执行：" + count);
		}
	}
	
	private Lock lock = new ReentrantLock();

	public  void testLock() {
		
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			lock.lock();
			count++;
			lock.unlock();
			
			
			System.out.println(Thread.currentThread().getName() + "正在执行：" + count);
		}
	}

}
