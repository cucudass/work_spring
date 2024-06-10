package com.lgy.spring_ex3_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainRectangle {
	public static void main(String[] args) {
		String configLoc = "classpath:rectangleCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		//getBean 메소드로 객체정보를 가져옴
		MyRectangle myRect = ctx.getBean("myrect", MyRectangle.class);
		
		myRect.ar();
	}
}