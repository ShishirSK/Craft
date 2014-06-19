package edu.string.character.unique;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckUniqueCharsTest {

	CheckUniqueChars chars = new CheckUniqueChars();
	
	@Test
	public void oneTrue() {
		assertTrue(chars.checkUnique("abcdefghi"));
	}
	
	@Test
	public void oneFalse(){
		assertFalse(chars.checkUnique("abchedjghea"));
	}

}
