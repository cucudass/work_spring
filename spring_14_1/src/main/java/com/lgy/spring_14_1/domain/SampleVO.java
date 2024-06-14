package com.lgy.spring_14_1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 프로퍼티를 파라미터로 가지는 생성자
@Data //여러가지 메소드를 포함
public class SampleVO {
	private int mno;
	private String firstName;
	private String lastName;
	
//	public SampleVO(int mno, String firstName, String lastName) {
//		this.mno = mno;
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
	
//	public SampleVO() {
//		
//	}
	
//	public int getMno() {
//		return mno;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setMno(int mno) {
//		this.mno = mno;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
}