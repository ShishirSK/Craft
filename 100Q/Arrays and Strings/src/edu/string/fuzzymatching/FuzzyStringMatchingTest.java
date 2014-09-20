package edu.string.fuzzymatching;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuzzyStringMatchingTest {

	FuzzyStringMatching anInstance = new FuzzyStringMatching();
	
	@Test
	public void trueTests() {
		assertTrue(anInstance.matchString("hello world", "h"));
		assertTrue(anInstance.matchString("hello world", "he"));
		assertTrue(anInstance.matchString("hello world", "hl"));
		assertTrue(anInstance.matchString("hello world", "ho"));
		assertTrue(anInstance.matchString("hello world", "hw"));
		assertTrue(anInstance.matchString("hello world", "hwo"));
		assertTrue(anInstance.matchString("hello world", "hwrl"));
		assertTrue(anInstance.matchString("hello world", "heow"));
		assertTrue(anInstance.matchString("hello world", "hlowd"));
	}
	
	@Test
	public void falseTests() {
		assertFalse(anInstance.matchString("hello world", "eh"));
		assertFalse(anInstance.matchString("hello world", "lh"));
		assertFalse(anInstance.matchString("hello world", "hh"));
		assertFalse(anInstance.matchString("hello world", "rw"));
		assertFalse(anInstance.matchString("hello world", "hdl"));
		assertFalse(anInstance.matchString("hello world", "horw"));
		assertFalse(anInstance.matchString("hello world", "hlro"));
	}

}
