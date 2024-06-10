package com.lgy.spring_ex3_1;

public class MyCircle {
	private Circle circle;
	private int r;
	
	public void ar() {
		circle.area(r);
	}
	
	public Circle getCircle() { return circle; }
	public int getR() { return r; }
	
	public void setCircle(Circle circle) { this.circle = circle; }
	public void setR(int r) { this.r = r; }
}