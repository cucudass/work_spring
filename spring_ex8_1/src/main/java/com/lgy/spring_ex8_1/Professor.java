package com.lgy.spring_ex8_1;

public class Professor {
	private String name, subject;
	private int age;
	
	public void getProfessorInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("나이 : " + getAge());
		System.out.println("과목 : " + getSubject());
	}
	
	public String getName() { return name; }
	public String getSubject() { return subject; }
	public int getAge() { return age; }
	
	public void setName(String name) { this.name = name; }
	public void setSubject(String subject) { this.subject = subject; }
	public void setAge(int age) { this.age = age; }
}
