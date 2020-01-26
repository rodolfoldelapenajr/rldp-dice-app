package com.rldp.diceapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rldp.diceapp.model.DiceRequest;
import com.rldp.diceapp.model.DiceResponse;
import com.rldp.diceapp.model.DiceRoll;
import com.rldp.diceapp.model.DiceSum;
import com.rldp.diceapp.mongodb.repository.DiceResponseRepository;
import com.rldp.diceapp.util.DiceUtil;

@Service
public class DiceService {
	private static final Logger log = LoggerFactory.getLogger(DiceService.class);

	private DiceResponseRepository diceResponseRepository;
	
	public DiceService (DiceResponseRepository diceResponseRepository) {
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

}
