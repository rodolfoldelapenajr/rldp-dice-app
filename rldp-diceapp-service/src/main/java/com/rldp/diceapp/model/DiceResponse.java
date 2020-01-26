package com.rldp.diceapp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.annotations.Entity;

@Entity(value = "diceResponse", noClassnameStored = true)
public class DiceResponse {

	private final List<DiceRoll> diceRollList = new ArrayList<>();

	private final Set<DiceSum> diceSumSet = new HashSet<>();

	private DiceRequest request;

	public DiceResponse() {
	}

	public DiceResponse(DiceRequest request) {
		this.request = request;
	}

	public List<DiceRoll> getDiceRollList() {
		return diceRollList;
	}

	public Set<DiceSum> getDiceSumSet() {
		return diceSumSet;
	}

	public DiceRequest getRequest() {
		return request;
	}

	public DiceSum get(int sum) {
		return diceSumSet.stream().filter(e -> e.getSum() == sum).findFirst().orElse(new DiceSum(sum));
	}

	public void add(DiceRoll diceRoll) {
		diceRollList.add(diceRoll);
	}

	public void add(DiceSum diceSum) {
		diceSumSet.add(diceSum);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		diceRollList.forEach(builder::append);
		getDiceSumSet().forEach(builder::append);
		return builder.toString();
	}
}
