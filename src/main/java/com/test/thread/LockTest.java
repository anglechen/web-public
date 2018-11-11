package com.test.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 消费者模型
 * @author Administrator
 *
 */
public class LockTest {

	public static void main(String[] args) {

		OperationLock operationLock = new OperationLock(new ReentrantLock());
		
//		放数据
		new Thread(()->{
			while(true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				operationLock.put();
			}
			
		}).start();
		
		try {
			Thread.sleep(11 *1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
//		拿数据
		new Thread(()->{
			while(true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				operationLock.get();
			}
			
		}).start();
		
	}

}



class OperationLock{
	
	private Lock lock = null;
	
	private Condition notFull= null;
	
	private Condition notEmpty = null;
	
	
	private int maxCount = 10;
	
	private int initCount = 0;
	
	private LinkedList<Integer>  list = new LinkedList<>();
	
	public OperationLock(Lock lock) {
		this.lock = lock;
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
	}
	
	public void put() {
		lock.lock();
		while(list.size() == maxCount) {
			try {
				System.out.println("放满了....");
				notEmpty.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		initCount++;
		list.add(initCount);
		System.out.println("放入了：" + initCount);
		notFull.signalAll();
		lock.unlock();
		
		
	}
	
	
	public void get() {
		lock.lock();
		
		while(list.size() == 0) {
			try {
				System.out.println("拿空了....");
				notFull.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("拿出了" + list.removeFirst());
		notEmpty.signalAll();
		lock.unlock();
		
		
	}
	
	
	
}



















