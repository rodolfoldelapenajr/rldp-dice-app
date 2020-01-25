package com.rldp.diceapp.model;

import javax.validation.constraints.Min;

public class DiceRequest {
	@Min(value = 1)
	private int pieces;
	@Min(value = 4)
	private int sides;
	@Min(value = 1)
	private int rolls;

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public int getRolls() {
		return rolls;
	}

	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

}
