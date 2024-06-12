package com.lgy.spring_ex8_1;

public class Singer {
	private String name, song;
	private int member;
	
	public void getSingerInfo() {
		System.out.println("이름 : " + getName());
		System.out.println("멤버 : " + getMember());
		System.out.println("노래 : " + getSong());
	}
	
	public String getName() { return name; }
	public String getSong() { return song; }
	public int getMember() {  return member; }
	
	public void setName(String name) { this.name = name; }
	public void setSong(String song) { this.song = song; }
	public void setMember(int member) { this.member = member; }
}