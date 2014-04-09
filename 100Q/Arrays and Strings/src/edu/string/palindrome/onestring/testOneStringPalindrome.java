package edu.string.palindrome.onestring;

import static org.junit.Assert.*;

import org.junit.Test;

public class testOneStringPalindrome {

	CheckPalindrome checkString = new CheckPalindrome();
//	boolean status;
	@Test
	public void aRandomString() {
		assertFalse("The string is not a palindrome", checkString.isPalindrome("aRandomString"));
	}

	@Test
	public void aPalindromeString(){
		assertTrue("The string is a palindrome", checkString.isPalindrome("racecar"));
	}

	@Test
	public void notAPalindromeString(){
		assertFalse("The string is not a palindrome", checkString.isPalindrome("not-a-palindrome"));
	}
	
	@Test
	public void aNonCharString(){
		assertFalse("The string is not a palindrome", checkString.isPalindrome("race-carabc"));
	}
	
	@Test
	public void anAlphanumericPalindrome(){
		assertTrue("The alhanumeric string is a palindrome", checkString.isPalindrome("12racecar21"));
	}
	
	@Test
	public void anAlphanumericPalindromeWithStuff(){
		assertTrue("The alhanumeric string is a palindrome", checkString.isPalindrome("12rac-ec'ar21"));
		assertTrue("The alhanumeric string is a palindrome", checkString.isPalindrome("he-did,eh?"));
	}
	
	@Test
	public void anAlphanumericUppercaseLettersPalindrome(){
		assertTrue("The alhanumeric string is a palindrome", checkString.isPalindrome("12Racecar21"));
		assertTrue("The alhanumeric string is a palindrome", checkString.isPalindrome("12RaCEcaR21"));
		assertTrue("The alhanumeric string is a palindrome", checkString.isPalindrome("hE-diD,eh"));
	}
	
	
}
