package edu.string.character.unique;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckUniqueCharsBitWiseTest {

	CheckUniqueCharsBitWise checkBits = new CheckUniqueCharsBitWise();
	
	@Test
	public void oneForPass() {
		assertTrue(checkBits.isUniqueBitWise("abcdefghi"));
	}
	
	@Test
	public void oneForFail(){
		assertFalse(checkBits.isUniqueBitWise("abcdefghia"));
	}

}
