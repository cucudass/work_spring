package com.lgy.spring_ex3_3;

public class Season {
	public void rsltSeason(int num) {
		switch (num) {
		case 12: case 1: case 2:
			System.out.println("입력된 정수가 " + num+"은 계절이 겨울");
			break;
		case 3: case 4: case 5:
			System.out.println("입력된 정수가 " + num+"은 계절이 봄");
			break;
		case 6: case 7: case 8:
			System.out.println("입력된 정수가 " + num+"은 계절이 여름");
			break;
		case 9: case 10: case 11:
			System.out.println("입력된 정수가 " + num+"은 계절이 가을");
			break;
		}
	}
}