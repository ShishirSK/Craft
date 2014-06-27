package edu.string.palindrome.longest;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromeInStringImpl2Test {

	LongestPalindromeInStringImpl2 longest = new LongestPalindromeInStringImpl2();
	
	@Test
	public void testOne() {
		assertEquals(longest.longestPalindrome("aaaa"), "aaaa");
	}

	@Test
	public void testTwo() {
		assertEquals(longest.longestPalindrome("eeeeeeeee"), "eeeeeeeee");
	}
	
}
