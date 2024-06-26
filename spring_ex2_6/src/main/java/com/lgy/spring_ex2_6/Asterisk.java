package com.lgy.spring_ex2_6;

public class Asterisk {
	private int num;
	
	public void process2() {
		for (int i = num; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void process() {
		StringBuffer sb = new StringBuffer();
		for (int i = num; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public int getNum() { return num; }

	public void setNum(int num) { this.num = num; }
}