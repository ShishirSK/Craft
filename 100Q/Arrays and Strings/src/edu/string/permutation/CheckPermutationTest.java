package edu.string.permutation;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckPermutationTest {

	CheckPermutation forTest = new CheckPermutation();

	@Test
	public void yesPerm() {
		assertTrue(forTest.isStrPermutation("abcdefghi", "ihgfedcba"));
	}

	@Test
	public void noPerm() {
		assertFalse(forTest.isStrPermutation("abcdefhji", "abcdefgha"));
	}

	@Test
	public void unequalStrings() {
		assertFalse(forTest.isStrPermutation("abcde", "abcdefgh"));
	}
}
