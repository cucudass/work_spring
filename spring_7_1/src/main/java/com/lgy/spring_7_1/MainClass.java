package com.lgy.spring_7_1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//스프링 설정(xml 스프링 설정파일 로딩)
		ctx.load("classpath:applicationCTX.xml");
		//새로고침(설정 반영): 생략해도 객체 정보 출력에는 문제 없음
		//ctx.refresh();
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]
//				이름 :홍길순
//				나이 :30

		Student student = ctx.getBean("student", Student.class);
		
		System.out.println("이름 :" + student.getName());
		System.out.println("나이 :" + student.getAge());
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@442675e1: startup date [Wed Jun 12 09:30:45 KST 2024]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@fd07cbb: defining beans [student]; root of factory hierarchy
//		이름 :홍길순
//		나이 :30
//		INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@442675e1: startup date [Wed Jun 12 09:30:45 KST 2024]; root of context hierarchy
//		INFO : org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@fd07cbb: defining beans [student]; root of factory hierarchy

		ctx.close();
	}
}