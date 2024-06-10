package com.lgy.spring_ex3_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainCircle {
	public static void main(String[] args) {
		String configLoc = "classpath:circleCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		//getBean 메소드로 객체정보를 가져옴
		MyCircle myCircle = ctx.getBean("myc", MyCircle.class);
		
		myCircle.ar();
	}
}