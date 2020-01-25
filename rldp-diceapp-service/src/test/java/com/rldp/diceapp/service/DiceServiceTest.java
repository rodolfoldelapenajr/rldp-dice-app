package com.rldp.diceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rldp.diceapp.model.DiceResponse;

class DiceServiceTest {
	
	private DiceService diceService = new DiceService();
	
	@Test
	void shouldRollDiceProperly() {
		DiceResponse diceResponse = diceService.rollDice();
		assertTrue(diceResponse.getDiceRollList().size() == 100);
	}

}
