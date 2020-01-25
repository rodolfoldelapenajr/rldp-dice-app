package com.rldp.diceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.rldp.diceapp.model.DiceRequest;
import com.rldp.diceapp.model.DiceResponse;

class DiceServiceTest {
	
	private DiceService diceService = new DiceService();
	
	@Test
	void shouldRollDiceProperly() {
		DiceRequest request = new DiceRequest();
		request.setPieces(3);
		request.setSides(6);
		request.setRolls(100);
		DiceResponse diceResponse = diceService.rollDice(request);
		assertEquals(100, diceResponse.getDiceRollList().size());
		List<Integer> results = diceResponse.getDiceRollList().get(0).getResults();
		assertEquals(3, results.size());
		results.forEach(num -> {
			assertTrue(num >= 1 && num <= 6);
		});
	}

}
