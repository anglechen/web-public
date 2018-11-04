package com.test.oop.card;

public class Unicom implements CardService {

	@Override
	public void sendMessage() {
		System.out.println("正在使用中国联通发短信....");

	}

	@Override
	public void sendPhone() {
		System.out.println("正在使用中国联通打电话....");

	}

}
