package web;

import com.test.web.Phone;
import com.test.web.card.CardService;
import com.test.web.card.Mobie;
import com.test.web.card.Telecom;
import com.test.web.card.Unicom;
import com.test.web.phone.Iphone;
import com.test.web.phone.Moto;
import com.test.web.phone.Nokia;
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
