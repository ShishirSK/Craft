package edu.string.palindrome.onestring;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class AlphanumericPalindrome {

	public boolean isPalindrome(String ipString) {
		
		// Edge case - considering empty string as palindrome
        if (ipString == null) 
            return true;
        
		StringBuilder str = new StringBuilder();
		char c;
		// Construct lowercase string with only alphanumeric chars
		for (int i = 0; i < ipString.length(); i++) {
			c = ipString.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				if (Character.isUpperCase(c))
					c = Character.toLowerCase(c);
				str.append(c);
			}
		}
		ipString = str.toString();

		// Compare the characters in forward and reverse order
		int j = 0, k = ipString.length() - 1;
		while (j <= k) {
			if (ipString.charAt(j++) != (ipString.charAt(k--))) {
				return false;
			}
		}
		return true;
	}
}
