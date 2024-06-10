package com.lgy.spring_ex3_5;

public class MyThree {
	private Three three;
	private int num;
	
	public void pc() {
		three.process(num);
	}
	
	public Three getThree() { return three; }
	public void setThree(Three three) { this.three = three; }
	public int getNum() { return num; }
	public void setNum(int num) { this.num = num; }
}