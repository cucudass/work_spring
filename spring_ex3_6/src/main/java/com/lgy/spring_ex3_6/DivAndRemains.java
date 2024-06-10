package com.lgy.spring_ex3_6;

public class DivAndRemains {
	public void process(int n) {
		int t = n / 10;
		int o = n % 10;
		
		if(t == o)
			System.out.println("입력된 수: "+n+"는 10의 자리와 1의 자리가 같습니다.");
		else
			System.out.println("입력된 수: "+n+"는 10의 자리와 1의 자리가 틀립니다.");
	}
}