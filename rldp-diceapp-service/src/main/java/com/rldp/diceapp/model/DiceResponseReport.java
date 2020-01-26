package com.rldp.diceapp.model;

import java.util.ArrayList;
import java.util.List;

public class DiceResponseReport {

	private final List<DiceResponseGroup> groupList = new ArrayList<>();

	public List<DiceResponseGroup> getGroupList() {
		return groupList;
	}
	
	public void add(DiceResponseGroup group) {
		groupList.add(group);
	}
}
