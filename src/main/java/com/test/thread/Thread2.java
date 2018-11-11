package com.test.thread;

public class Thread2 implements Runnable {

	private ThreadBusiness tb;
	
	public Thread2(ThreadBusiness tb) {
		this.tb = tb;
	}
	
	@Override
	public void run() {
		tb.test();
	}

}
