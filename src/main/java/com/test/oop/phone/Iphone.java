package com.test.oop.phone;

import com.test.oop.Phone;
import com.test.oop.inter.Blooth;
import com.test.oop.inter.Wifi;

public class Iphone extends 
	Phone implements Wifi, Blooth  {

	@Override
	public void timer() {
		System.out.println("这里是iphone的闹钟");
	}

	@Override
	public void wifi() {
		System.out.println("这里是iphone的wifi");
		
	}

	@Override
	public void blooth() {
		System.out.println("这里是iphone的蓝牙");
		
	}

}
