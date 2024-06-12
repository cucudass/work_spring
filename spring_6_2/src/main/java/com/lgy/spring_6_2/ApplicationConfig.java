package com.lgy.spring_6_2;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 설정 파일로 사용
@Configuration //"스프링 설정에 사용되는 클래스"라고 명시해 주는 어노테이션
public class ApplicationConfig {
	//빈 객체 생성
	@Bean
	public Student student1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student student = new Student("홍길동", 20, hobbys); //생성자 설정
		//프로퍼티 설정
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악감상");
		
		Student student = new Student("홍길순", 18, hobbys); //생성자 설정
		//프로퍼티 설정
		student.setHeight(170);
		student.setWeight(55);
		
		return student;
	}
}