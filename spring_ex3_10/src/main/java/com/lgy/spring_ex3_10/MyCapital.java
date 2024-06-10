package com.lgy.spring_ex3_10;

public class MyCapital {
	private Capital capital;
	private char ch;
	
	public void alpha() {
		capital.alphabet(ch);
	}
	
	public Capital getCapital() { return capital; }
	public char getCh() { return ch; }
	
	public void setCapital(Capital capital) { this.capital = capital; }
	public void setCh(char ch) { this.ch = ch; }
}