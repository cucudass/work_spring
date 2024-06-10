package com.lgy.spring_ex3_6;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainDivAndRemains {
	public static void main(String[] args) {
		String configLoc = "classpath:divAndRemainsCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyDivAndRemains mdar = ctx.getBean("mdar", MyDivAndRemains.class);
		
		mdar.pc();
	}
}