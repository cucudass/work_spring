package com.lgy.Spring_4_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc = "classpath:myInfo.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		
		//이름~취미, BMI 지수, 비만~저체중 출력
		myInfo.getInfo();
		//자원반납
		ctx.close();
	}
}
