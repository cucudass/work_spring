package com.lgy.spring_ex2_6;

public class Capital {
	private char str;
	
	public void process() {
		char c = 'A';
		for (int i = str; i >= c; i--) {
			for (int j = c; j <= i; j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}
	}
	
	public char getStr() { return str; }

	public void setStr(char str) { this.str = str; }
}