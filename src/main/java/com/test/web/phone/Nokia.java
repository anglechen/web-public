package com.test.web.phone;

import com.test.oop.Phone;
import com.test.web.inter.Wifi;

public class Nokia extends Phone implements Wifi {

	@Override
	public void timer() {
		System.out.println("这里是nokia的闹钟");
		
	}

	@Override
	public void wifi() {
		System.out.println("这里是nokia的wifi");
		
	}

}
