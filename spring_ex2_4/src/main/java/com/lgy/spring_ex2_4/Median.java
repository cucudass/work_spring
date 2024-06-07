package com.lgy.spring_ex2_4;

import java.util.Arrays;

public class Median {
	private int a, b, c;
	
	public void process() {
		System.out.print("입력된 정수가 "+a+"와"+b+"와"+c+"의 중간값은 ");
		int[] arr = {a,b,c};
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}
	
	public int getA() { return a; }
	public int getB() { return b; }
	public int getC() { return c; }
	
	public void setA(int a) { this.a = a; }
	public void setB(int b) { this.b = b; }
	public void setC(int c) { this.c = c; }
}
