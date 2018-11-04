package com.test.oop;

import com.test.web.card.CardService;

import lombok.Data;

@Data
public abstract  class Phone {
	
	
	private CardService cardService;
	
	
	
	public void start() {
		System.out.println("正在开机.....");
	}
	
	public void close() {
		System.out.println("正在关机.....");
	}
	
	
	public abstract  void timer();
	
	
	
	
	
}
