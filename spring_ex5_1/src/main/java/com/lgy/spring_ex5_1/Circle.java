package com.lgy.spring_ex5_1;

public class Circle {
	private int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public void process() {
		System.out.println("원의 면걱은: "+(Math.pow(radius, 2)*3.14));
	}
	
	public int getRadius() { return radius; }

	public void setRadius(int radius) { this.radius = radius; }
}