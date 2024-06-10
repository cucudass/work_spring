package com.lgy.spring_ex3_9;

public class EvenNumber {
	public void process(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			if(i % 2 == 0)
				sum += i;
		}
		System.out.println(n+"까지의 짝수들의 합계는 "+sum);
	}
}