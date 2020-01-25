package com.rldp.diceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.rldp.diceapp.model.DiceResponse;

class DiceServiceTest {
	
	private DiceService diceService = new DiceService();
	
	@Test
	void shouldRollDiceProperly() {
		DiceResponse diceResponse = diceService.rollDice(3, 6, 100);
		assertEquals(100, diceResponse.getDiceRollList().size());
		List<Integer> results = diceResponse.getDiceRollList().get(0).getResults();
		assertEquals(3, results.size());
		results.forEach(num -> {
			assertTrue(num >= 1 && num <= 6);
		});
	}

}
