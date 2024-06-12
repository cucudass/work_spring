package com.lgy.spring_7_2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		
		//student1 -> 홍길순
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println("이름: "+student1.getName());
		System.out.println("나이: "+student1.getAge());
		System.out.println("=======================");
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("홍길자");
		student2.setAge(100);
		System.out.println("이름: "+student2.getName());
		System.out.println("나이: "+student2.getAge());
		System.out.println("=======================");
		
		if(student1 == student2)
			System.out.println("student1 == student2");
		else
			System.out.println("student1 != student2");
		
		ctx.close();
	}
}