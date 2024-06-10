package com.lgy.spring_ex3_9;

public class MyEvenNumber {
	private EvenNumber even;
	private int num;
	
	public void pc() {
		even.process(num);
	}
	
	public EvenNumber getEven() { return even; }
	public int getNum() { return num; }
	
	public void setEven(EvenNumber even) { this.even = even; }
	public void setNum(int num) { this.num = num; }
}