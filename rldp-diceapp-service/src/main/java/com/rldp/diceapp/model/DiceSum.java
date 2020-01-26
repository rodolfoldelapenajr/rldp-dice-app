package com.rldp.diceapp.model;

import java.io.Serializable;

public class DiceSum implements Serializable {

	private static final long serialVersionUID = -9190327630272338656L;

	private int sum;
	private int count;

	public DiceSum(int sum) {
		this.sum = sum;
	}

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

	public void add() {
		this.count++;
	}

	@Override
	public int hashCode() {
		return sum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DiceSum) {
			return this.sum == ((DiceSum) obj).sum;
		}
		return false;
	}

	@Override
	public String toString() {
		return "sum: " + sum + " count: " + count + "\n";
	}

}
