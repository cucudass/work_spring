package com.lgy.spring_6_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLoc1 = "classpath:applicationCTX1.xml";
		String configLoc2 = "classpath:applicationCTX2.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc1, configLoc2);
		Student student1 = ctx.getBean("student1", Student.class);
		//홍길동
		//[수영, 요리]
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		//student1의 객체를 참조
		Student student2 = studentInfo.getStudent();
		//홍길동
		//[수영, 요리]
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		//동일한 객체
		if(student1.equals(student2))
			System.out.println("student1 == student2");
		else
			System.out.println("student1 != student2");
		
		//홍길자 객체 정보 가져옴
		Student student3 = ctx.getBean("student3", Student.class);
		//홍길자
		//[줄넘기, 공기놀이]
		System.out.println(student3.getName());
		System.out.println(student3.getHobbys());
		
		//다른 객체
		if(student1.equals(student3))
			System.out.println("student1 == student3");
		else
			System.out.println("student1 != student3");
		
		Family family = ctx.getBean("family", Family.class);
		//홍아빠
		//홈엄마
		//홍누나
		//홍오빠
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
	}
}
