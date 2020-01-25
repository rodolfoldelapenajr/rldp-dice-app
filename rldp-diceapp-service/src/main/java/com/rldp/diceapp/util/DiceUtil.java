package com.rldp.diceapp.util;

import java.util.Random;

public final class DiceUtil {

	private static final Random rand = new Random();

	private DiceUtil() {
	}

	public static int rand(int min, int max) {
		int number = 0;
		do {
			number = rand.nextInt(max + 1);
		} while (number < min);
		return number;
	}
}
