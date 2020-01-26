package com.rldp.diceapp.service;

import java.util.List;

import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rldp.diceapp.model.DiceRequest;
import com.rldp.diceapp.model.DiceResponse;
import com.rldp.diceapp.model.DiceResponseGroup;
import com.rldp.diceapp.model.DiceResponseReport;
import com.rldp.diceapp.model.DiceRoll;
import com.rldp.diceapp.model.DiceSum;
import com.rldp.diceapp.mongodb.repository.DiceResponseRepository;
import com.rldp.diceapp.util.DiceUtil;

@Service
public class DiceService {
	private static final Logger log = LoggerFactory.getLogger(DiceService.class);

	private DiceResponseRepository diceResponseRepository;

	public DiceService(DiceResponseRepository diceResponseRepository) {
		this.diceResponseRepository = diceResponseRepository;
	}

	public DiceResponse rollDice(DiceRequest request) {
		final DiceResponse dice = new DiceResponse(request);
		for (int i = 0; i < request.getRolls(); i++) {
			rollDice(dice, request.getPieces(), request.getSides());
		}

		log.info("dice response: {}", dice);
		diceResponseRepository.save(dice);
		return dice;
	}

	private void populateSumList(final DiceRoll diceRoll, final DiceResponse diceResponse) {
		final DiceSum diceSum = diceResponse.get(diceRoll.getSum());
		diceSum.add();
		diceResponse.add(diceSum);
	}

	private void rollDice(DiceResponse dice, Integer pieces, Integer sides) {
		final DiceRoll diceRoll = new DiceRoll();
		for (int i = 0; i < pieces; i++) {
			int random = DiceUtil.rand(1, sides);
			diceRoll.add(random);
		}
		populateSumList(diceRoll, dice);
		dice.add(diceRoll);
	}

	public DiceResponseReport getResults() {
		final DiceResponseReport report = new DiceResponseReport();
		final Query<DiceResponse> query = diceResponseRepository.createQuery();
		List<DiceResponse> list = query.asList();
		if (list != null) {
			populateReports(report, list);
		}
		return report;
	}

	private void populateReports(final DiceResponseReport report, List<DiceResponse> list) {
		DiceResponseGroup group = null;
		DiceRequest previousRequest = null;
		for (int i = 0; i < list.size(); i++) {
			final DiceResponse response = list.get(i);
			final DiceRequest currentRequest = response.getRequest();
			final boolean sameCombination = currentRequest.equals(previousRequest);
			if (!sameCombination) {
				group = new DiceResponseGroup(currentRequest);
			}
			group.add(response);
			if (i == list.size() - 1 || !currentRequest.equals(list.get(i + 1).getRequest())) {
				report.add(group);
			}
			previousRequest = currentRequest;
		}
	}

}
