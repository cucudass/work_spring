package com.lgy.spring_ex2_2;

public class SeasonDollar {
	public static void main(String[] args) {
		Season season = new Season();
		Won2dollar wd = new Won2dollar();
		
		season.setMonth(9);
		wd.setDollar(3300);
		
		season.process();
		wd.process();
	}
}