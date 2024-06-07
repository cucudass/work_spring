package com.lgy.spring_ex2_1;

public class Circle {
	private int r;

	public int getR() { return r; }
	public void setR(int r) { this.r = r; }
	
	public void area() {
		System.out.println("원의 면적은 " + (Math.pow(r, 2) * 3.14));
	}
}
