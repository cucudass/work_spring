package com.lgy.spring_ex5_1;

public class CircleInfo {
	private Circle circle;
	
	public CircleInfo(Circle circle) {
		this.circle = circle;
	}
	
	public void getCircleInfo() {
		if(circle != null) {
			System.out.println("반지름: " + circle.getRadius());
			circle.process();
		}
	}

	public void setCircel(Circle circle) { this.circle = circle; }
}