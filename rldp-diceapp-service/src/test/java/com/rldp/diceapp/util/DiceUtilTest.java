package com.rldp.diceapp.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class DiceUtilTest {

	@Test
	void shouldReturnRandomNumbersBetweenMinAndMax() {
		Set<Integer> integers = new HashSet<>();
		int min = 1;
		int max = 100;
		int diff = max - min;
		while (integers.size() <= diff) {
			int rand = DiceUtil.rand(min, max);
			integers.add(rand);
			assertTrue(rand >= min);
			assertTrue(rand <= max);
		}
		assertEquals(max, integers.size());
	}

}
