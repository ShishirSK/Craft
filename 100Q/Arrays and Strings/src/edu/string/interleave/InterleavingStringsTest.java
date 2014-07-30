package edu.string.interleave;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterleavingStringsTest {

	InterleavingStrings stringsObj = new InterleavingStrings();
	
	@Test
	public void test() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		assertTrue(stringsObj.isInterleave(s1, s2, s3));

	}

	@Test
	public void test2() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s4 = "aadbbbaccc";
		
		assertFalse(stringsObj.isInterleave(s1, s2, s4));
	}
	
	@Test
	public void test3() {
		String s1 = "bcccb";
		String s2 = "bccbbaba";
		String s4 = "bacccccbbbbba";
		
		assertFalse(stringsObj.isInterleave(s1, s2, s4));
	}
}
