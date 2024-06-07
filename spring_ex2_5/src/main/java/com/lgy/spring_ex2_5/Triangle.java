package com.lgy.spring_ex2_5;

import java.util.Arrays;

public class Triangle {
	private int num1, num2, num3;

	public void process() {
		int[] arr = {num1, num2, num3};
		Arrays.sort(arr);
		
		if(arr[0] + arr[1] > arr[2])
			System.out.println("삼각형이 됩니다.");
		else
			System.out.println("삼각형이 안됩니다.");
	}
	
	public int getNum1() { return num1; }
	public int getNum2() { return num2; }
	public int getNum3() { return num3; }
	
	public void setNum1(int num1) { this.num1 = num1; }
	public void setNum2(int num2) { this.num2 = num2; }
	public void setNum3(int num3) { this.num3 = num3; }
}