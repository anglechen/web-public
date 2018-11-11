package com.test.thread;

public class Thread1Test {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		ThreadBusiness tb = new ThreadBusiness();
		for (int i = 0; i < 10; i++) {
			Thread t1 = new Thread1(tb);
			t1.start();
		}

		while(Thread.activeCount() > 1)Thread.yield();
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end -start));
		System.out.println("count : " + ThreadBusiness.count);
		System.out.println("主线程执行完毕");
			
	}
	
	

}
