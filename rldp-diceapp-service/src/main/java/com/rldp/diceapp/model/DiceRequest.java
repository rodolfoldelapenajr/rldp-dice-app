package com.rldp.diceapp.model;

import java.time.Instant;

import javax.validation.constraints.Min;

public class DiceRequest extends DistinctRequest{
	
	private static final long serialVersionUID = -3736520037159435489L;

	@Min(value = 1)
	private int rolls;
	
    private Instant timestamp;
    
	public DiceRequest() {
		this.timestamp = Instant.now();
	}

	public int getRolls() {
		return rolls;
	}

	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof DiceRequest) {
			DiceRequest param = (DiceRequest) obj;
			return pieces == param.getPieces() && sides == param.getSides();
		}
		return false;
	}
}
