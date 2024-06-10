package com.lgy.spring_ex3_4;

public class MyWon2Dollar {
	private Won2Dollar w2d;
	private int money;
	
	public void exch() {
		w2d.exchange(money);
	}
	
	public Won2Dollar getW2d() { return w2d; }
	public int getMoney() { return money; }
	
	public void setW2d(Won2Dollar w2d) { this.w2d = w2d; }
	public void setMoney(int money) { this.money = money; }
}