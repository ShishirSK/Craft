package edu.string.commonprefix;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

	LongestCommonPrefix astr = new LongestCommonPrefix();
	
	@Test
	public void test() {
		
		String arr[] = {"C", "C"};
		assertEquals(astr.longestCommonPrefix(arr), "C");
		
	}

}
