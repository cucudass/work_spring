package com.lgy.spring_ex3_7;

public class MyRectangle {
	private Rectangle rectangle;
	private int x, y;
	
	public void pc() {
		rectangle.process(x, y);
	}
	
	public Rectangle getRectangle() { return rectangle; }
	public int getX() { return x; }
	public int getY() { return y; }
	
	public void setRectangle(Rectangle rectangle) { this.rectangle = rectangle; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
}