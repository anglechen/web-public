package com.test.web.phone;

import com.test.oop.Phone;
import com.test.web.inter.Blooth;

public class Moto extends Phone implements Blooth {

	@Override
	public void timer() {
		System.out.println("这里是moto的闹钟");
		
	}

	@Override
	public void blooth() {
		System.out.println("这里是moto的蓝牙");
		
	}

}
