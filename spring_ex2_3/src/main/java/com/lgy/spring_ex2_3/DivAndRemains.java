package com.lgy.spring_ex2_3;

public class DivAndRemains {
	private int num;
	
	public void process() {
		int t = num / 10;
		int o = num % 10;
		if(t == o)
			System.out.println("10의 자리와 1의 자리가 같습니다.");
		else 
			System.out.println("10의 자리와 1의 자리가 다릅니다.");
	}
	
	public int getNum() { return num; }

	public void setNum(int num) { this.num = num; }
}