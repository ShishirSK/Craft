package edu.string.palindrome.longest;

import java.util.Arrays;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class LongestPalindromeInStringImpl2 {

	int palLength = 0;
	int palStartPos = 0;
	int largestShift = 0;
	int longestPalLength = 0;

	public String longestPalindrome(String str) {

		if (str.length() == 1)
			return str;

		char[] carray = str.toCharArray();

		// Check for cases where length < 4.
		// Refactor this block
		// ------------------------------------------------------
		if (carray.length < 4) {
			if (carray.length == 2 && carray[0] == carray[1]) {
				return str;
			} else if (carray.length == 2 && carray[0] != carray[1]) {
				return String.valueOf(carray[0]);
			}

			if (carray.length == 3 && carray[0] == carray[2]) {
				return str;
			} else if (carray.length == 3 && carray[0] != carray[1]) {
				if (carray[0] != carray[1] && carray[1] != carray[2]) {
					return String.valueOf(carray[0]);
				} else if (carray[0] != carray[1] && carray[1] == carray[2])
					return (String.valueOf(carray[1]) + String
							.valueOf(carray[2]));
			} else if (carray[0] == carray[1] && carray[1] != carray[2])
				return (String.valueOf(carray[0]) + String.valueOf(carray[1]));
		}
		// Refactor this block
		// ------------------------------------------------------

		// Check for cases where length > 4. Note the difference. 
		for (int i = 1; i < carray.length - 1; i++) {

			if (carray[i] == carray[i - 1]) {
				getPossiblePalindrome(carray, i - 1, i, 0);
			}

			if (carray[i - 1] == carray[i + 1]) {
				getPossiblePalindrome(carray, i - 1, i + 1, 1);
			}
		}

		char[] palArray = Arrays.copyOfRange(carray, palStartPos + 1,
				palStartPos + longestPalLength + 1);
		String pal = String.valueOf(palArray);
		return pal;
	}

	/**
	 * @param charray
	 *            - array with all characters
	 * @param leftPos
	 *            - left pointer to check character
	 * @param rightPos
	 *            - right pointer to check character
	 * @param centerPos
	 *            - pointer to the center position of palindrome - O in case of
	 *            even length palindrome - 1 in case of odd length palindrome
	 */
	private void getPossiblePalindrome(char[] charray, int leftPos,
			int rightPos, int centerPos) {

		int shiftCount = 0;

		while (leftPos >= 0 && rightPos < charray.length) {
			if (charray[leftPos] == charray[rightPos]) {
				leftPos--;
				rightPos++;
				shiftCount++;
			} else
				break;
		}

		if (shiftCount >= largestShift) {
			largestShift = shiftCount;
			palLength = 2 * shiftCount + centerPos; // 2 is due to shift of both
													// pointers simultaneously
			// Longest palindrome check for cases like "eeeeeeeee"
			if (palLength > longestPalLength) {
				longestPalLength = palLength;
				palStartPos = leftPos++;
			}
		}
	}
}
