package com.rldp.diceapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DiceResponse {
	private final List<DiceRoll> diceRollList = new ArrayList<>();
	private final Map<Integer, Integer> sumMap = new HashMap<>();

	public void add(DiceRoll diceRoll) {
		diceRollList.add(diceRoll);
	}

	public List<DiceRoll> getDiceRollList() {
		return diceRollList;
	}

	public Set<DiceSum> getDiceSumSet() {
		return sumMap.entrySet().stream().map(map -> {
			DiceSum diceSum = new DiceSum();
			diceSum.setSum(map.getKey());
			diceSum.setCount(map.getValue());
			return diceSum;
		}).collect(Collectors.toSet());
	}

	@JsonIgnore
	public Map<Integer, Integer> getSumMap() {
		return sumMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		diceRollList.forEach(builder::append);
		getDiceSumSet().forEach(builder::append);
		return builder.toString();
	}
}
