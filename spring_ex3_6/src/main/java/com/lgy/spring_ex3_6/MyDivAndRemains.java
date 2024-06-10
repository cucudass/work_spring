package com.lgy.spring_ex3_6;

public class MyDivAndRemains {
	private DivAndRemains dar;
	private int n;

	public void pc() {
		dar.process(n);
	}
	public DivAndRemains getDar() { return dar; }
	public int getN() { return n; }
	
	public void setDar(DivAndRemains dar) { this.dar = dar; }
	public void setN(int n) { this.n = n; }
}