package com.lgy.spring_ex2_1;

public class Draw {
	public static void main(String[] args) {
		//Draw 클래스가 Circle, Rectangle 클래스에 의존
		Circle c = new Circle();
		Rectangle rect = new Rectangle();
		
		c.setR(10);
		rect.setX(20);
		rect.setY(30);
		
		c.area();
		rect.area();
	}
}
