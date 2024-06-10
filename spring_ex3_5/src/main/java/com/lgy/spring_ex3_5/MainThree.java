package com.lgy.spring_ex3_5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainThree {
	public static void main(String[] args) {
		String configLoc = "classpath:threeCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyThree mythree = ctx.getBean("mythree", MyThree.class);
		
		mythree.pc();
	}
}