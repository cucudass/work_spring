package com.lgy.spring_ex2_3;

public class ThreeDivAndRemains {
	public static void main(String[] args) {
		Three three = new Three();
		DivAndRemains dar = new DivAndRemains();
		
		three.setNum(129);
		dar.setNum(77);
		
		three.process();
		dar.process();
	}
}