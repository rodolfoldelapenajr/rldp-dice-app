package com.rldp.diceapp.model;

public class DiceSum {
	private int sum;
	private int count;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return  "sum: " + sum + " count: " + count + "\n";
	}
	
}
