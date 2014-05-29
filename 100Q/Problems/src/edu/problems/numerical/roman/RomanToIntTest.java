package edu.problems.numerical.roman;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToIntTest {

	RomanToInt romans = new RomanToInt();

	@Test
	public void LessThan100() {
		assertEquals(romans.romanToInt("XLIX"), 49);
		assertEquals(romans.romanToInt("XCII"), 92);
		assertEquals(romans.romanToInt("LXXVII"), 77);
	}

	@Test
	public void LessThan1000() {
		assertEquals(romans.romanToInt("CDXXXVI"), 436);
		assertEquals(romans.romanToInt("DCLIV"), 654);
		assertEquals(romans.romanToInt("CMLXXXIX"), 989);
	}
}
