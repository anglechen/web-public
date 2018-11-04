package com.oop.test;

import com.test.oop.Phone;
import com.test.oop.card.CardService;
import com.test.oop.card.Mobie;
import com.test.oop.card.Telecom;
import com.test.oop.card.Unicom;
import com.test.oop.phone.Iphone;
import com.test.oop.phone.Moto;
import com.test.oop.phone.Nokia;
//测试类
public class PhoneTest {
	
	public static void main(String[] args) {
		callPhone(new Nokia(),new Mobie());
		System.out.println("=============");
		callPhone(new Iphone(),new Unicom());
		System.out.println("=============");
		callPhone(new Moto(),new Telecom());
		System.out.println("=============");
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void callPhone(Phone p1,CardService cardIn) {
		p1.start();
		p1.timer();
		p1.setCardService(cardIn);
		CardService cardService = p1.getCardService();
		cardService.sendMessage();
		cardService.sendPhone();
		p1.close();
	}
	
	
	
}
