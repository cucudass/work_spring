package com.lgy.spring_6_1;

public class Family {
	private String papaName;
	private String mamiName;
	private String sisterName;
	private String brotherName;
	
	public Family(String papaName, String mamiName) {
		this.papaName = papaName;
		this.mamiName = mamiName;
	}
	
	public String getPapaName() { return papaName;  }
	public String getMamiName() { return mamiName; }
	public String getSisterName() { return sisterName; }
	public String getBrotherName() { return brotherName; }
	
	public void setPapaName(String papaName) { this.papaName = papaName; }
	public void setMamiName(String mamiName) { this.mamiName = mamiName; }
	public void setSisterName(String sisterName) { this.sisterName = sisterName; }
	public void setBrotherName(String brotherName) { this.brotherName = brotherName; }
}