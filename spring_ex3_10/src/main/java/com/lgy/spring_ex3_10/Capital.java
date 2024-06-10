package com.lgy.spring_ex3_10;

public class Capital {
	public void alphabet(char ch) {
		char c = 'A';
		for (int i = ch; i >= c; i--) {
			for (int j = c; j <= i; j++) {
				System.out.print((char)j);
			}
			System.out.println();
		}
	}
}