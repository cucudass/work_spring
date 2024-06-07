package com.lgy.spring_ex2_1;

public class Rectangle {
	private int x, y;
	
	public void area() {
		System.out.println("사각형의 면적은 " + (x*y));
	}
	
	public int getX() { return x; }
	public int getY() { return y; }

	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
}
