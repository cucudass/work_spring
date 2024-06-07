package com.lgy.spring_ex2_5;

public class Multiple {
	private int num;
	
	public void process() {
		boolean flag = false;
		if(num % 3 == 0) {
			System.out.println("3의 배수이다.");
			flag = true;
		} 
		if(num % 5 == 0) {
			System.out.println("5의 배수이다.");
			flag = true;
		}
		if(num % 8 == 0) {
			System.out.println("8의 배수이다.");
			flag = true;
		}
		if(!flag)
			System.out.println("어느 배수도 아닙니다.");
	}
	
	public int getNum() { return num; }
	
	public void setNum(int num) { this.num = num; }
}