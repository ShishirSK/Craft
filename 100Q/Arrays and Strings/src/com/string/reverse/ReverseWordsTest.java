package com.string.reverse;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseWordsTest {

	ReverseWords str = new ReverseWords();
	String reverseString = null;

	@Test
	public void ConsecutiveSpacesTest() {
		reverseString = str.reverseWords("   a   b ");
		assertEquals(reverseString, "b a");
	}

	@Test
	public void EmptyStringTest() {
		reverseString = str.reverseWords("");
		assertEquals(reverseString, "");
	}

	@Test
	public void ALongerStringToReverseTest() {
		reverseString = str.reverseWords("  This is a   longer string to reverse   !");
		assertEquals(reverseString, "! reverse to string longer a is This");
	}
}
