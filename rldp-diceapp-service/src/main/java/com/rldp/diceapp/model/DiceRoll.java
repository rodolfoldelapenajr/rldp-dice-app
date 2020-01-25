package com.rldp.diceapp.model;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
	private final List<Integer> results = new ArrayList<>();;
	private int sum;

	public List<Integer> getResults() {
		return results;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void add(int number) {
		this.results.add(number);
		this.sum += number;
	}

	@Override
	public String toString() {
		return "reuslts: " + results.toString() + " sum: " + sum + "\n";
	}

}
