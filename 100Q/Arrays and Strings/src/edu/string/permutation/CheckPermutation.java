package edu.string.permutation;

/**
 * Check if one string is permutation of other
 * 
 * @author Shishir Kinkar
 * 
 */
public class CheckPermutation {

	public boolean isStrPermutation(String str1, String str2) {

		if (str2.length() != str1.length()) {
			return false;
		}

		int[] mapOrig = new int[256]; // Assume ASCII
		int charIndex;

		// For characters in the string, make array position value as 1
		for (int i = 0; i < str1.length(); i++) {
			charIndex = str1.charAt(i);
			mapOrig[charIndex] = 1;
		}

		// If string is not a permutation, the value at the position would be
		// less than 0 after reducing it by 1
		for (int j = 0; j < str2.length(); j++) {
			charIndex = str2.charAt(j);
			if (--mapOrig[charIndex] < 0) {
				return false;
			}
		}
		return true;
	}
}
