package com.rldp.diceapp.model;

public class DiceSumDistribution {

	private Double percentage;
	private DiceSum diceSum;

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public DiceSum getDiceSum() {
		return diceSum;
	}

	public void add(DiceSum diceSum) {
		if (this.diceSum == null) {
			this.diceSum = new DiceSum(diceSum.getSum());
		}
		this.diceSum.setCount(this.diceSum.getCount() + diceSum.getCount());
	}
}
