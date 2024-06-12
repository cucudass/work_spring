package com.lgy.spring_ex6_3;

import java.util.ArrayList;

public class Singer {
	private String name;
	private int member;
	private ArrayList<String> song;
	
	public Singer(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
	public int getMember() { return member; }
	public ArrayList<String> getSong() { return song; }
	
	public void setName(String name) { this.name = name; }
	public void setMember(int member) { this.member = member; }
	public void setSong(ArrayList<String> song) { this.song = song; }
}