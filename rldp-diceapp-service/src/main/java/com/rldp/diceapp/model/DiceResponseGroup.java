package com.rldp.diceapp.model;

import java.util.ArrayList;
import java.util.List;

public class DiceResponseGroup {

	private int totalRolls;
	private int totalSimulations;
	private List<DiceSumDistribution> diceSumDistributionList;

	private final List<DiceResponse> diceResponseList = new ArrayList<>();

	private final DistinctRequest request;

	public DiceResponseGroup(DistinctRequest request) {
		this.request = request;
	}

	public List<DiceResponse> getDiceResponseList() {
		return diceResponseList;
	}

	public DistinctRequest getRequest() {
		return request;
	}
	
	public int getTotalRolls() {
		return totalRolls;
	}
	
	public int getTotalSimulations() {
		return totalSimulations;
	}

	public List<DiceSumDistribution> getDiceSumDistributionList() {
		return diceSumDistributionList;
	}

	public void setDiceSumDistributionList(List<DiceSumDistribution> diceSumDistributionList) {
		this.diceSumDistributionList = diceSumDistributionList;
	}

	public void add(DiceResponse response) {
		diceResponseList.add(response);
		totalRolls += response.getDiceRollList().size();
		totalSimulations += 1;
	}
}
