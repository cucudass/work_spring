package com.lgy.spring_ex2_2;

public class Won2dollar {
	private int dollar;

	public void process() {
		System.out.println("$"+(dollar / 1200.0));
	}
	
	public int getDollar() { return dollar; }

	public void setDollar(int dollar) { this.dollar = dollar; }
}
