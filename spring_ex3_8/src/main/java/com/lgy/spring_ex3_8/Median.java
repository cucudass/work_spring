package com.lgy.spring_ex3_8;

import java.util.Arrays;

public class Median {
	public void process(int a, int b, int c) {
		int[] arr = {a,b,c};
		Arrays.sort(arr);
		System.out.println("입력된 정수가 "+a+"와 "+b+"와 "+c+"의 중간값은 "+arr[1]);
	}
}