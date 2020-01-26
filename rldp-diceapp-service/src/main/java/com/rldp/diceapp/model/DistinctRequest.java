package com.rldp.diceapp.model;

import java.io.Serializable;

import javax.validation.constraints.Min;

public class DistinctRequest implements Serializable{
	
	private static final long serialVersionUID = -3768388045188163561L;
	@Min(value = 1)
	protected int pieces;
	@Min(value = 4)
	protected int sides;

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
	
}
