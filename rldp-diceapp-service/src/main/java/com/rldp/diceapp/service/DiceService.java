package com.rldp.diceapp.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rldp.diceapp.model.DiceResponse;
import com.rldp.diceapp.model.DiceRoll;
import com.rldp.diceapp.util.DiceUtil;

@Service
public class DiceService {
	private static final Logger log = LoggerFactory.getLogger(DiceService.class);

	public DiceResponse rollDice() {
		final DiceResponse dice = new DiceResponse();
		for (int i = 0; i < 100; i++) {
			rollDice(dice);
		}

		log.info("dice response: {}", dice);
		return dice;
	}

	private void populateSumList(final DiceRoll diceRoll, final Map<Integer, Integer> sumMap) {
		final Integer sum = sumMap.get(diceRoll.getSum());
		final int total = (sum == null ? 0 : sum) + 1;
		sumMap.put(diceRoll.getSum(), total);
	}

	private void rollDice(DiceResponse dice) {
		DiceRoll diceRoll = new DiceRoll();
		for (int i = 0; i < 3; i++) {
			int random = DiceUtil.rand(1, 6);
			diceRoll.add(random);
		}
		populateSumList(diceRoll, dice.getSumMap());
		dice.add(diceRoll);
	}

}
