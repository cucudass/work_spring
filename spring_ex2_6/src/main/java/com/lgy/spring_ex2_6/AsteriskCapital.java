package com.lgy.spring_ex2_6;

public class AsteriskCapital {
	public static void main(String[] args) {
		Asterisk aster = new Asterisk();
		aster.setNum(5);
		aster.process();
		
		Capital cap = new Capital();
		cap.setStr('F');
		cap.process();
	}
}