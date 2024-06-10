package com.lgy.Spring_4_1;

import java.util.ArrayList;

public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbys;
	private BMICalculator bmiCalculator;
	
	//BMI 지수, 비만~저체중 출력
	public void bmiCalcuation() {
		bmiCalculator.bmiCalculation(weight, height);
	}
	
	//이름~취미, BMI 지수, 비만~저체중 출력
	public void getInfo() {
		System.out.println("이름: " + name);
		System.out.println("키: " + height);
		System.out.println("몸무게: " + weight);
		System.out.println("취미: " + hobbys);
		
		bmiCalcuation();
	}
	
	public String getName() { return name; }
	public double getHeight() { return height; }
	public double getWeight() { return weight; }
	public ArrayList<String> getHobbys() { return hobbys; }
	public BMICalculator getBmiCalculator() { return bmiCalculator; }
	
	public void setName(String name) { this.name = name; }
	public void setHeight(double height) { this.height = height; }
	public void setWeight(double weight) { this.weight = weight; }
	public void setHobbys(ArrayList<String> hobbys) { this.hobbys = hobbys; }
	public void setBmiCalculator(BMICalculator bmiCalculator) { this.bmiCalculator = bmiCalculator; }
}