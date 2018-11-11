package com.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * 通过thread 实现线程
 * @author Administrator
 *
 */
public class Thread1 extends Thread {
	
	private ThreadBusiness tb;
	
	public Thread1(ThreadBusiness tb) {
		this.tb = tb;
	}
	
	
	@Override
	public void run() {
//		tb.test();
		tb.testLock();
	}
}
