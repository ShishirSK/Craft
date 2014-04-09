package edu.string.character.capitalize;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCapitalizationOfChars {

	CapitalizeLetters caps = new CapitalizeLetters();
	String returnString = null;
	@Test
	public void shortString() {
		returnString = caps.CapitalizeSelectively("Hello");
		assertEquals(returnString, "abcdEfgHijkLmnOpqrstuvwxyz" );
	}
	
	@Test
	public void longString() {
		returnString = caps.CapitalizeSelectively("ThisIsALongString");
		assertEquals(returnString, "AbcdefGHIjkLmNOpqRSTuvwxyz");
	}
	
	@Test
	public void stringWithSpace() {
		returnString = caps.CapitalizeSelectively("Hello There");
		assertEquals(returnString, "abcdEfgHijkLmnOpqRsTuvwxyz" );
	}
	
	@Test
	public void stringWithOtherChars() {
		returnString = caps.CapitalizeSelectively("Hello O' Friend!");
		assertEquals(returnString, "abcDEFgHIjkLmNOpqRstuvwxyz" );
	}
}
